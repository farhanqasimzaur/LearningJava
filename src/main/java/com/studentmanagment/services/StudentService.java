package com.studentmanagment.services;

import com.studentmanagment.models.Students;

import java.util.List;

public interface StudentService {
    Students getStudent(String id);
    List getAllStudents();
    void updateAge(String id, int age);
    void deleteStudent(int id);
    void addStudent(String name, int age);
}
