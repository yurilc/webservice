package com.wipro.topic6assignment1.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Movie {
    @XmlElement
    private String movieId;
    @XmlElement
    private String movieName;
    @XmlElement
    private String movieActor;
    @XmlElement
    private float movieCollection;

    public Movie() {
    }

    public Movie(String movieId, String movieName, String movieActor, float movieCollection) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieActor = movieActor;
        this.movieCollection = movieCollection;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public float getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(float movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieActor='" + movieActor + '\'' +
                ", movieCollection=" + movieCollection +
                '}';
    }
}
