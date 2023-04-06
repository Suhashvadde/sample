package com.example.demo.dto;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="Movie")
public class Movie {


	@Id
	@Column(name = "imdbID")
	private String imdbID;
	@Column(name = "title")
	private String title;
	@Column(name = "releasedYear")
	private String year;
	@Column(name = "rated")
	private String rated;
	@Column(name = "released")
	private String released;
	@Column(name = "runtime")
	private String runtime;
	@Column(name="genre")
	private String genre;
	@Column(name="director")
	private String director;
	@Column(name="actors")
	private String actors;
	@Column(name="plot")
	private String plot;
	@Column(name="language")
	private String language;
	@Column(name="country")
	private String country;
	@Column(name="poster")
	private String poster;
	@Column(name="imdbRating")
	private String imdbRating;
	@Column(name="owner")
	private String owner;



	public Movie() {

	}
}
