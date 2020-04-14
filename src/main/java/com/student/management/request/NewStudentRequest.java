package com.student.management.request;

import com.student.management.model.Student;

import javax.validation.constraints.NotNull;

public class NewStudentRequest {

    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Age cannot be null")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getDto(){
        Student student = new Student();
        student.setName(this.name);
        student.setAge(this.age);
        return student;
    }
}
