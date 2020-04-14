package com.studentmanagment.controllers;

import com.studentmanagment.models.Students;
import com.studentmanagment.services.StudentsServiceBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("v1/students")
public class StudentsController {

    private StudentsServiceBean studentsServiceBean = new StudentsServiceBean();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List getStudentsDOA() {
        List students = studentsServiceBean.getAllStudents();
        return students;
    }

    @GET
    @Path("/{param}")
    @Produces({MediaType.APPLICATION_JSON})
    public Students getStudentWithId(@PathParam("param") String id) {
        Students students = studentsServiceBean.getStudent(id);
        return students;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(Students students) {
        studentsServiceBean.addStudent(students.name, students.age);
    }

    @PUT
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(Students students, @PathParam("param") String id) {
        studentsServiceBean.updateAge(id, students.age);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteStudent(Students students) {
        studentsServiceBean.deleteStudent(students.id);
    }
}
