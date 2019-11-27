package com.wipro.topic6assignment1.service;

import com.wipro.topic6assignment1.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {
    private static final List<Movie> MOVIES = Arrays.asList(
            new Movie("M001", "Top Gun", "Tom Cruise", 3500000),
            new Movie("M002", "Alien", "Sigourney Weaver", 100000.2f),
            new Movie("M003", "Alien II", "Sigourney Weaver", 200000),
            new Movie("M004", "Alien III", "Sigourney Weaver", 300000.5f),
            new Movie("M005", "Prometheus", "Charlize Theron", 400000),
            new Movie("M006", "Fast and Furious", "Vin Diesel", 500000.8f),
            new Movie("M007", "Fast and Furious II", "Vin Diesel", 600000),
            new Movie("M008", "Fast and Furious: Tokyo", "Vin Diesel", 700000),
            new Movie("M009", "Fast and Furious IV", "Vin Diesel", 800000),
            new Movie("M010", "Fast and Furious V", "Vin Diesel", 990000.9f)
    );

    public List<Movie> findAll() {
        return MOVIES;
    }

    public Movie findById(String id) {
        return MOVIES.stream()
                .filter(m -> m.getMovieId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
