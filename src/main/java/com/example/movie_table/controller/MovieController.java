package com.example.movie_table.controller;

import com.example.movie_table.Entity.Movie;
import com.example.movie_table.dto.MemberReadResponseDto;
import com.example.movie_table.dto.MovieCreateResponseDto;
import com.example.movie_table.dto.MovieReadResponseDto;
import com.example.movie_table.dto.MovieUpdateResponseDto;
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
    public ResponseEntity<MovieCreateResponseDto> createMovie(@RequestBody Movie movie) {
        MovieCreateResponseDto createMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(createMovie, HttpStatus.CREATED);


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
    public ResponseEntity<MovieUpdateResponseDto> updateMovieById(@PathVariable Long id, @RequestBody Movie movie) {
        MovieUpdateResponseDto updatedMovie = movieService.updateMovieById(id, movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.NO_CONTENT);
    }


}
