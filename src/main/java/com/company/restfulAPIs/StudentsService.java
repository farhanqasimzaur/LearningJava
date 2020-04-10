package com.company.restfulAPIs;

import java.util.ArrayList;

public class StudentsService {

    private static StudentsService instantiation = null;

    private ArrayList<StudentModel> studentsList = new ArrayList<>();

    public static StudentsService instantiate(){
        if(instantiation != null) {
            return instantiation;
        }
        instantiation = new StudentsService();
        return instantiation;
    }

    private StudentsService() {}

    public void addStudent(StudentModel student) {
        studentsList.add(student);
    }
    public ArrayList<StudentModel> getStudents() {
        return studentsList;
    }
}
