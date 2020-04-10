package com.company.hibernate;

import java.util.HashMap;

public class Students {
    private int id;
    private String name;
    private int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Students(HashMap student) {
        this.name = (String) student.get("name");
        this.age = (int) student.get("age");
        this.id = (int) student.get("id");
    }

    public Students(){}

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getId(){ return id;}
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }


}
