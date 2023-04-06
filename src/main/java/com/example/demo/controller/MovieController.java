package com.example.demo.controller;

import java.util.List;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.model.MoviePatchRequest;
import com.example.demo.service.MovieDataLoadService;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.demo.dto.Movie;


@RestController
public class MovieController {
	

	@Autowired
	private MovieDataLoadService movieDataLoadService;

	@Autowired
	private MovieService movieService;
	
	
	@GetMapping(value = "/loadMovies")
	public void loadMovies(@RequestParam String title) {
		movieDataLoadService.loadMoviesByTitle(title);
	}
	

	@GetMapping(value = "/movies/{imdbID}")
	public Movie getMovie(@PathVariable String imdbID) {
        return movieService.getMovie(imdbID);
	}

	@GetMapping(value = "/movies/genre/{genre}")
	public List<Movie> getMoviesByGenre(@PathVariable String genre) {
		return movieService.getMoviesByGenre(genre);
	}

	@GetMapping(value = "/movies/title/{title}")
	public List<Movie> getMoviesByTitle(@PathVariable String title) {
		return movieService.getMoviesByTitle(title);
	}
	@GetMapping(value = "/movies/actors/{actors}")
	public List<Movie> getMoviesByActors(@PathVariable String actors) {
		return movieService.getMoviesByActors(actors);
	}
	@PatchMapping(value = "/movies/{imdbID}")
	public void updateMovie(@PathVariable String imdbID, @RequestBody MoviePatchRequest moviePatchRequest) {
		 movieService.updateMovie(imdbID,moviePatchRequest);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> entityNotFound(EntityNotFoundException ex) {
		return new ResponseEntity<>("Requested movie is not found",HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> exception(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
