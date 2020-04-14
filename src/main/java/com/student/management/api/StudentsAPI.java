package com.student.management.api;

import com.student.management.model.Student;
import com.student.management.request.NewStudentRequest;
import com.student.management.request.UpdateStudentRequest;
import com.student.management.business.StudentService;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("v1/students")
public class StudentsAPI {

    @EJB
    private StudentService studentService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Student> getStudentsDOA() {
        return studentService.getAllStudents();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Student getStudentWithId(@PathParam("id") Integer id) {
        return studentService.getStudent(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(@Valid NewStudentRequest newStudentRequest) {
        studentService.addStudent(newStudentRequest.getDto());
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(@Valid UpdateStudentRequest updateStudentRequest) {
        studentService.updateStudent(updateStudentRequest.getDto());
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") Integer id) {
        studentService.deleteStudent(id);
        return Response.ok().build();
    }
}
