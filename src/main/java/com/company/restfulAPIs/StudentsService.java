package com.company.restfulAPIs;

import java.util.ArrayList;

public class StudentsService {

    private static StudentsService instantiation = null;

    private ArrayList<StudentsModel> studentsList = new ArrayList<>();

    public static StudentsService instantiate(){
        if(instantiation != null) {
            return instantiation;
        }
        instantiation = new StudentsService();
        return instantiation;
    }

    private StudentsService() {}

    public void addStudent(StudentsModel student) {
        studentsList.add(student);
    }
    public ArrayList<StudentsModel> getStudents() {
        return studentsList;
    }
}
