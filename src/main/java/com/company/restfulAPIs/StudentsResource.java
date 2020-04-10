package com.company.restfulAPIs;

import com.company.connectingMySQL.Students;
import org.json.JSONArray;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;

@Path("/v1/students")
public class StudentsResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList getStudentName() {
        Students students = new Students();
        ArrayList studentsList = students.getAll();
        JSONArray mJSONArray = new JSONArray(Arrays.asList(studentsList));

        return studentsList;
    }
}
