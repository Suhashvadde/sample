package com.example.demo.respository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dto.Movie;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, String> {

     List<Movie> findByGenreContaining(String genre);
     List<Movie> findByTitleContaining(String title);

     List<Movie> findByActorsContaining(String actors);
}
