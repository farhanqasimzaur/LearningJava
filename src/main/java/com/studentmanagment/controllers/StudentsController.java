package com.studentmanagment.controllers;

import com.studentmanagment.models.Students;
import services.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/students")
public class StudentsController {
    StudentsService studentsService = new StudentsService();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List getStudentsDOA() {
        List students = studentsService.getAllStudents();
        return students;
    }

    @GET
    @Path("/{param}")
    @Produces({MediaType.APPLICATION_JSON})
    public Students getStudentWithId(@PathParam("param") String id) {
        Students students = studentsService.getStudent(id);
        return students;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(Students students) {
        studentsService.addStudent(students.name, students.age);
    }

    @PUT
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(Students students, @PathParam("param") String id) {
        studentsService.updateAge(id, students.age);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteStudent(Students students) {
        studentsService.deleteStudent(students.id);
    }
}
