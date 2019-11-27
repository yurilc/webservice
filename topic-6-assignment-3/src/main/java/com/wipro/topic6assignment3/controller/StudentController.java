package com.wipro.topic6assignment3.controller;

import com.wipro.topic6assignment3.domain.Student;
import com.wipro.topic6assignment3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GET
    public List<Student> findAll(@QueryParam("class") String clazz, @MatrixParam("class") String classMatrixParam,
                                 @QueryParam("id") String id, @MatrixParam("id") String idMatrixParam,
                                 @QueryParam("mark") float mark, @MatrixParam("mark") float markMatrixParam) {
        if(classMatrixParam != null) {
            clazz = classMatrixParam;
        }
        if(idMatrixParam != null) {
            id = idMatrixParam;
        }
        if(markMatrixParam != 0) {
            mark = markMatrixParam;
        }
        return studentService.findAll(id, mark, clazz);
    }

    @Path("/{id}")
    @GET
    public Student findById(@PathParam("id") String id) {
        return studentService.findById(id);
    }

    @Path("/mark/{mark}")
    @GET
    public List<Student> findByMarkGreater(@PathParam("mark") float mark) {
        return studentService.findByMarkGreater(mark);
    }

    @Path("/class/{class}")
    @GET
    public List<Student> findByClass(@PathParam("class") String clazz) {
        return studentService.findByClass(clazz);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student create(Student student) {
        return studentService.save(student);
    }

    @Path("/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") String id, Student student) {
        try {
            student.setStudentId(id);
            return Response.ok(studentService.update(student)).build();
        } catch (EntityNotFoundException e) {
            return Response.status(404).build();
        }
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") String id) {
        try {
            return Response.ok(studentService.delete(id)).build();
        } catch (EntityNotFoundException e) {
            return Response.status(404).build();
        }
    }
}
