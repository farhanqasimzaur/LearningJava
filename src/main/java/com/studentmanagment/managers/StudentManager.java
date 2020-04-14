package com.studentmanagment.managers;

import com.studentmanagment.models.Students;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentManager extends HibernateManager {
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
        Query<Students> query = session.createNamedQuery("Students-retrieveWithID");
        query.setParameter("studentID", studentID);
        Students student = query.getSingleResult();
        session.close();
        return student;
    }

    public List listStudents( ){
        Session session = factory.openSession();

        Query query = session.createNamedQuery("Students-retrieveAll");
        List studentsList = (List) query.getResultList();
        session.close();
        return studentsList;
    }


    public void updateStudent(Integer studentID, int age) {
        Session session = factory.openSession();
        Query query = session.createNamedQuery("Students-updateAge");
        query.setParameter("studentAge", age);
        query.setParameter("studentID", studentID);
        executeWithTransaction(query, session);
    }

    public void deleteStudent(Integer studentID) {
        Session session = factory.openSession();
        Query query = session.createNamedQuery("Students-deleteWithID");
        query.setParameter("studentID", studentID);
        executeWithTransaction(query, session);
    }

    private void executeWithTransaction(Query query, Session session) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!= null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
