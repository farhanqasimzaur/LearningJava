package com.student.management.business.impl;

import com.student.management.business.StudentService;
import com.student.management.dao.StudentDao;
import com.student.management.model.Student;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@Local(StudentService.class)
public class StudentServiceBean implements StudentService {

    @Inject
    private StudentDao studentDao;

    @Override
    public Student getStudent(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.merge(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.delete(studentDao.findById(id));
    }

    @Override
    public void addStudent(Student student) {
        studentDao.save(student);
    }


}



