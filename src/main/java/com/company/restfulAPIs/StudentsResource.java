package com.company.restfulAPIs;

import com.company.connectingMySQL.Students;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;

@Path("/v1/students")
public class StudentsResource {
    Students students = new Students();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList getStudents() {
        ArrayList studentsList = students.getAll();
        return studentsList;
    }

    @GET
    @Path("/{param}")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList getStudentWithId(@PathParam("param") String id) {
        ArrayList studentsList = students.getWith(parseInt(id));
        return studentsList;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(StudentModel studentModel) {
        students.create(studentModel.name, studentModel.age);
    }

    @PUT
    @Path("/{param}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStudent(StudentModel studentModel, @PathParam("param") String id) {
        students.updateAge(parseInt(id), studentModel.age);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteStudent(StudentModel studentModel) {
        students.delete(studentModel.id);
    }
}
