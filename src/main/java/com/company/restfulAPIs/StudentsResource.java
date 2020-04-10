package com.company.restfulAPIs;

import com.company.connectingMySQL.StudentsDOA;
import com.company.hibernate.StudentManagement;
import com.company.hibernate.Students;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;

@Path("/v1/students")
public class StudentsResource {
    StudentsDOA studentsDOA = new StudentsDOA();
    StudentManagement studentManagement = new StudentManagement();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Students getStudentsDOA() {
        ArrayList studentsList = studentsDOA.getAll();
        Students students = studentManagement.listStudents();
        return students;
    }

    @GET
    @Path("/{param}")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList getStudentWithId(@PathParam("param") String id) {
        ArrayList studentsList = studentsDOA.getWith(parseInt(id));
        return studentsList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(StudentsModel studentsModel) {
        studentsDOA.create(studentsModel.name, studentsModel.age);
    }

    @PUT
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(StudentsModel studentsModel, @PathParam("param") String id) {
        studentsDOA.updateAge(parseInt(id), studentsModel.age);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteStudent(StudentsModel studentsModel) {
        studentsDOA.delete(studentsModel.id);
    }
}
