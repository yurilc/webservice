package com.wipro.topic7assignment1.controller;

import com.wipro.topic7assignment1.domain.Employee;
import com.wipro.topic7assignment1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GET
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Path("/{id}")
    @GET
    public Employee findById(@PathParam("id") String id) {
        return employeeService.findById(id);
    }

    @Path("/location/{location}")
    @GET
    public List<Employee> findByLocation(@PathParam("location") String location) {
        return employeeService.findByLocation(location);
    }

    @Path("/band/{band}")
    @GET
    public List<Employee> findByClass(@PathParam("band") String band) {
        return employeeService.findByBand(band);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Employee create(Employee employee) {
        return employeeService.save(employee);
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(@PathParam("id") String id, Employee employee) {
        try {
            employee.setEmpId(id);
            return Response.ok(employeeService.update(employee)).build();
        } catch (EntityNotFoundException e) {
            return Response.status(404).build();
        }
    }
}
