package com.studentmanagment.controllers;

import com.studentmanagment.managers.StudentManager;
import com.studentmanagment.models.Students;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.lang.Integer.parseInt;

@Path("v1/students")
public class StudentsController {
    StudentManager studentManagement = new StudentManager();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List getStudentsDOA() {
        List students = studentManagement.listStudents();
        return students;
    }

    @GET
    @Path("/{param}")
    @Produces({MediaType.APPLICATION_JSON})
    public Students getStudentWithId(@PathParam("param") String id) {
        Students students = studentManagement.getStudent(parseInt(id));
        return students;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(Students students) {
        studentManagement.addStudent(students.name, students.age);
    }

    @PUT
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(Students students, @PathParam("param") String id) {
        studentManagement.updateStudent(parseInt(id), students.age);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteStudent(Students students) {
        studentManagement.deleteStudent(students.id);
    }
}
