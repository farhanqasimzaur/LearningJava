package com.company;

import com.company.connectingMySQL.Students;
import com.company.restfulAPIs.RestClient;

public class Main {

    public static void main(String[] args) {
//        Students student = new Students();
//        student.create("hello", 20);
//        student.delete(7);
//        student.create("new", 20);
//        student.updateAge(1, 50);
//        student.getAll();

        RestClient restClient = new RestClient();
        //fire the get request on the server
        restClient.getRequest();
        //method to fire the post request on the server
//        restClient.postRequest();
    }
}
