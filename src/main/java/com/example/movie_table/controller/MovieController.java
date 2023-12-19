package com.example.movie_table.controller;

import com.example.movie_table.Entity.Movie;
import com.example.movie_table.dto.request.movie.MovieCreateRequestDto;
import com.example.movie_table.dto.request.movie.MovieUpdateRequestDto;
import com.example.movie_table.dto.response.movie.MovieCreateResponseDto;
import com.example.movie_table.dto.response.movie.MovieReadResponseDto;
import com.example.movie_table.dto.response.movie.MovieUpdateResponseDto;
import com.example.movie_table.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController("/movie")
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController( MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieCreateResponseDto> createMovie(@RequestBody MovieCreateRequestDto movie) {
        MovieCreateResponseDto createdMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<MovieReadResponseDto>> getAllMovies() {
        List<MovieReadResponseDto> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieReadResponseDto> getMovieById(@PathVariable Long id) {
        MovieReadResponseDto movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
//        Movie movie = (Movie)movieService.getMovieById(id).orElseThrow();
//        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieUpdateResponseDto> updateMovieById(@PathVariable Long id, @RequestBody MovieUpdateRequestDto movie) {
        MovieUpdateResponseDto updatedMovie = movieService.updateMovieById(id, movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.NO_CONTENT);
    }


}
