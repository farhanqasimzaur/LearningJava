package models;

import javax.persistence.*;

@Entity
@Table(name="STUDENTS")
public class Students {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

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