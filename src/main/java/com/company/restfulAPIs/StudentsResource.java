package com.company.restfulAPIs;

import com.company.connectingMySQL.StudentsDOA;
import com.company.hibernate.StudentManagement;
import com.company.hibernate.StudentNamedQueries;
import com.company.hibernate.Students;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.lang.Integer.parseInt;

@Path("/v1/students")
public class StudentsResource {
    StudentManagement studentManagement = new StudentManagement();

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
    public void createStudent(StudentsModel studentsModel) {
        studentManagement.addStudent(studentsModel.name, studentsModel.age);
    }

    @PUT
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(StudentsModel studentsModel, @PathParam("param") String id) {
        studentManagement.updateStudent(parseInt(id), studentsModel.age);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteStudent(StudentsModel studentsModel) {
        studentManagement.deleteStudent(studentsModel.id);
    }
}
