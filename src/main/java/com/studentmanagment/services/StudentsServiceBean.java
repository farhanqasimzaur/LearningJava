package com.studentmanagment.services;

import com.studentmanagment.managers.StudentManager;
import com.studentmanagment.models.Students;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import static java.lang.Integer.parseInt;

@Local(StudentService.class)
@Stateless
public class StudentsServiceBean implements StudentService {

    private StudentManager studentManager = new StudentManager();

    public Students getStudent(String id) {
        return studentManager.getStudent(parseInt(id));
    }

    public List getAllStudents() {
        return studentManager.listStudents();
    }

    public void updateAge(String id, int age) {
        studentManager.updateStudent(parseInt(id), age);
    }

    public void deleteStudent(int id) {
        studentManager.deleteStudent(id);
    }

    public void addStudent(String name, int age) {
        studentManager.addStudent(name, age);
    }
}
