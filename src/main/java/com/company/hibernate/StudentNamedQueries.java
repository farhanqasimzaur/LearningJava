package com.company.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class StudentNamedQueries {
    private static SessionFactory factory;

    public StudentNamedQueries(){
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

    public List listStudents(){
        Session session = factory.openSession();
        String hql = "FROM com.company.hibernate.Students";
        Query query = session.createQuery(hql);
        return (List) query.list();
    }

    public List getStudentWith(int id){
        Session session = factory.openSession();
        String hql = "From Students S where S.id = :studentID";

        Query query = session.createQuery(hql);
        return (List) query.list();
    }
}
