package com.example.movie_table.service;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import com.example.movie_table.dto.*;
import com.example.movie_table.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieCreateResponseDto createMovie(Movie movie) {
        movieRepository.save(movie);
        return new MovieCreateResponseDto(movie.getId(), movie.getTitle(), movie.getReleaseDate(), movie.getAverageRating());
//        return movieRepository.save(movie);
    }

    public List<MovieReadResponseDto> getAllMovies() {
        List<MovieReadResponseDto> dto = new ArrayList<>();
        List<Movie> movies = movieRepository.findAll();
        for (Movie m : movies) {
            dto.add(new MovieReadResponseDto(m.getId(), m.getTitle(), m.getDirectors(), m.getGenres(), m.getActors(), m.getReleaseDate(), m.getAverageRating()));
        }
        return dto;
//        return movieRepository.findAll();
    }

    public MovieReadResponseDto getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        return new MovieReadResponseDto(movie.getId(), movie.getTitle(), movie.getDirectors(), movie.getGenres(), movie.getActors(), movie.getReleaseDate(), movie.getAverageRating());
//        return movieRepository.findById(id);
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
