package com.wipro.topic7assignment2;


import com.wipro.topic7assignment2.domain.Employee;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class RestClient {
    public static void main(String... args) throws Exception {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080");

        WebTarget employeeEndpoint = target.path("employees");

        System.out.println("Requesting [GET] on " + employeeEndpoint.getUri() + " ...");

        String response = employeeEndpoint.request(MediaType.APPLICATION_XML)
                .get(String.class);

        System.out.println("Response: " + response);

        WebTarget locationEndpoint = employeeEndpoint.path("location/London");

        System.out.println("Requesting [GET] on " + locationEndpoint.getUri() + " ...");

        response = locationEndpoint.request(MediaType.APPLICATION_XML)
                .get(String.class);

        System.out.println("Response: " + response);

        WebTarget bandEndpoint = employeeEndpoint.path("band/B3");

        System.out.println("Requesting [GET] on " + bandEndpoint.getUri() + " ...");

        response = bandEndpoint.request(MediaType.APPLICATION_XML)
                .get(String.class);

        System.out.println("Response: " + response);

        WebTarget deleteEndpoint = employeeEndpoint.path("EM001");

        System.out.println("Requesting [DELETE] on " + deleteEndpoint.getUri() + " ...");

        response = deleteEndpoint.request(MediaType.APPLICATION_XML)
                .delete(String.class);

        System.out.println("Response: " + response);
    }
}
