package com.student.management.dao.impl;

import com.student.management.dao.BaseDao;
import com.student.management.dao.StudentDao;
import com.student.management.model.Student;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl extends BaseDao<Student> implements StudentDao {

    private Class<Student> clazz;

    public StudentDaoImpl() {
        super(Student.class);
        this.clazz = Student.class;
    }

    public List<Student> getAllStudents( ){
        List<Student> students = new ArrayList<>();
        try{
            students = em
                    .createNamedQuery("Student.getAllStudents", clazz)
                    .getResultList();

        } catch(NoResultException ex){
            ex.printStackTrace();
        }
        return students;
    }


    /*private void executeWithTransaction(Query query, Session session) {
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
    }*/

}
