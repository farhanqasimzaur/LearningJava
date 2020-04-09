package com.company.restfulAPIs;

import org.omg.CORBA.Request;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/v1/students")
public class StudentsResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    StudentModel student;
    public StudentsResource(UriInfo uriInfo, javax.ws.rs.core.Request request, String id) {
        student = new StudentModel("Sara", 33);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStudentName() {
        return student.getName();
    }
}
