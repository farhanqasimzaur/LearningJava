package com.studentmanagment.models;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery(name = "Students-retrieveAll", query = "from Students"),
                @NamedQuery(name = "Students-retrieveWithID", query = "from Students where id = :studentID"),
                @NamedQuery(name = "Students-updateAge", query = "Update Students set age = :studentAge where id = :studentID"),
                @NamedQuery(name = "Students-deleteWithID", query = "delete from Students where id = :studentID"),
        }
)

@Entity
@Table(name="students")
public class Students {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "age")
    public int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Students() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId(){ return id;}
    public void setId(int id) {
        this.id = id;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

