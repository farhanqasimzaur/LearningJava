package com.student.management.dao;

import com.student.management.model.Student;

import java.util.List;

public interface StudentDao extends IDao<Student>{

    List<Student> getAllStudents();
}
