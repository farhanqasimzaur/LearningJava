package com.company.restfulAPIs;

import java.util.HashMap;

public class StudentModel {
    int id;
    String name;
    int age;

    public StudentModel(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public StudentModel(HashMap student) {
        this.name = (String) student.get("name");
        this.age = (int) student.get("age");
        this.id = (int) student.get("id");
    }
    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getId() { return this.id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
