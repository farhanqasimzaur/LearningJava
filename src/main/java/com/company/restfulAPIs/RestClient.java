package com.company.restfulAPIs;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    public void getRequest() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080").path("students");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        StudentModel studentModel = new StudentModel("zd", 34);

        System.out.println(response.getStatus());
        System.out.println(studentModel.getName());
    }

}
