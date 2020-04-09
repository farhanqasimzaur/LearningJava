package com.company.restfulAPIs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentModel {
    @XmlElement String name;
    @XmlElement int age;

    public StudentModel(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public StudentModel(StudentModel student) {
        this.name = student.name;
        this.age = student.age;
    }
    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
