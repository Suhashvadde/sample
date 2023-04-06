package com.example.demo.service;

import com.example.demo.dto.Movie;
import com.example.demo.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieDataLoadService {

    @Value("${movie.service.list-movies-by-title-endpoint}")
    String movieServiceListMoviesByTitleEndpoint;

    @Value("${movie.service.get-movie-details-endpoint}")
    String movieServiceGetMovieDetailsEndpoint;

    RestTemplate movieRestTemplate;

    MovieRepository movieRepository;


    @Autowired
    MovieDataLoadService(@Qualifier("movieRestTemplate") RestTemplate movieRestTemplate,
                         MovieRepository movieRepository){
        this.movieRestTemplate = movieRestTemplate;
        this.movieRepository = movieRepository;
    }

    public void loadMoviesByTitle(String title) {
        Movie[] movies =  movieRestTemplate.getForEntity(movieServiceListMoviesByTitleEndpoint, Movie[].class,title).getBody();

        List<Movie> moviesWithDetails = new ArrayList<>();

        for(Movie movie: movies){
            moviesWithDetails.add(getMovieDetails(movie));
        }

        movieRepository.saveAll(moviesWithDetails);
    }

    private Movie getMovieDetails(Movie movie) {
        return movieRestTemplate.getForEntity(movieServiceGetMovieDetailsEndpoint, Movie.class, movie.getImdbID()).getBody();
    }
}
