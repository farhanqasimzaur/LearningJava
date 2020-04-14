package com.student.management.business;

import com.student.management.model.Student;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentService {

    /**
     * Gets student By ID
     */
    Student getStudent(Integer id);


    /*
    * Gets all students
    * */
    List<Student> getAllStudents();


    /*
    * Updates the Student
    * */
    void updateStudent(Student student);


    /*
    * Deletes the Student by ID
    * */
    void deleteStudent(int id);

    /*
    * Saves the Student
    * */
    void addStudent(Student student);

}
