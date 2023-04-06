package com.example.demo.model;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MoviePatchRequest {
    private String title;
    private String year;
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String poster;
    private String imdbRating;
    private String owner;

}
