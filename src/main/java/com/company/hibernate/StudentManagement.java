package com.company.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import java.util.List;

public class StudentManagement {
    private static SessionFactory factory;

    public StudentManagement(){
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "admin123");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/learningJava");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");
            factory = configuration.addAnnotatedClass(Students.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer addStudent(String name, int age){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer studentID = null;

        try {
            tx = session.beginTransaction();
            Students student = new Students(name, age);
            studentID = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentID;
    }

    public Students getStudent(Integer studentID ){
        Session session = factory.openSession();
        Transaction tx = null;
        Students students = null;
        try {
            tx = session.beginTransaction();
            students = session.get(Students.class, studentID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    public List listStudents( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List studentsList = null;
        try {
            tx = session.beginTransaction();
            studentsList = session.createQuery("FROM Students").list();
            for (Iterator iterator = studentsList.iterator(); iterator.hasNext();){
            Students students = (Students) iterator.next();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentsList;
    }


    public void updateStudent(Integer studentID, int age) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Students student = (Students) session.get(Students.class, studentID);
            student.setAge(age);
            session.update(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteStudent(Integer studentID) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Students student = (Students) session.get(Students.class, studentID);
            session.delete(student);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
