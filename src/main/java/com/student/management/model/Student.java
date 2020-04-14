package com.student.management.model;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(name = "Student.getAllStudents",
                        query = "SELECT student " +
                                "FROM Student student")
        }
)

@Entity
@Table(name="student")
public class Student extends BaseEntity {


    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return (this.id.equals(student.getId()));
    }
}

