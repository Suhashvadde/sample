package com.example.demo.service;

import com.example.demo.dto.Movie;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.model.MoviePatchRequest;
import com.example.demo.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.example.demo.utils.ApplicationUtils.updateOnTargetIfNonNullFromSource;

@Service
public class MovieService {

    MovieRepository movieRepository;
    @Autowired
    MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie getMovie(String imdbID){
        return movieRepository.findById(imdbID).orElseThrow(EntityNotFoundException::new);
    }

    public List<Movie> getMoviesByGenre(String genre){
        return movieRepository.findByGenreContaining(genre);
    }

    public List<Movie> getMoviesByTitle(String title){
        return movieRepository.findByTitleContaining(title);
    }

    public List<Movie> getMoviesByActors(String actors){
        return movieRepository.findByActorsContaining(actors);
    }
    public void updateMovie(String imdbID, MoviePatchRequest moviePatchRequest){

        Movie movie  = movieRepository.findById(imdbID).orElseThrow(EntityNotFoundException::new);
        updateMovieFields(movie,moviePatchRequest);
        movieRepository.save(movie);
    }

    private void updateMovieFields(Movie movie, MoviePatchRequest moviePatchRequest){
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getTitle,movie::setTitle);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getRated,movie::setRated);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getYear,movie::setYear);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getReleased,movie::setReleased);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getRuntime,movie::setRuntime);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getGenre,movie::setGenre);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getDirector,movie::setDirector);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getActors,movie::setActors);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getPlot,movie::setPlot);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getLanguage,movie::setLanguage);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getCountry,movie::setCountry);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getPoster,movie::setPoster);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getImdbRating,movie::setImdbRating);
        updateOnTargetIfNonNullFromSource(moviePatchRequest::getOwner,movie::setOwner);
    }


}
