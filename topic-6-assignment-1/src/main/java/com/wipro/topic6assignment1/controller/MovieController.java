package com.wipro.topic6assignment1.controller;

import com.wipro.topic6assignment1.domain.Movie;
import com.wipro.topic6assignment1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GET
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @Path("/{movieId}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Movie findById(@PathParam("movieId") String id) {
        return movieService.findById(id);
    }
}
