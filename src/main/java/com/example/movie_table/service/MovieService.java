package com.example.movie_table.service;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import com.example.movie_table.dto.MovieUpdateResponseDto;
import com.example.movie_table.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public MovieUpdateResponseDto updateMovieById(Long id, Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            movie.setId(id);
            movieRepository.save(movie);
        }
        return movie.toDto();
    }

    public void deleteMovieById(Long id) {
    }


}
