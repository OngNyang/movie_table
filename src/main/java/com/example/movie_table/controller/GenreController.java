package com.example.movie_table.controller;

import com.example.movie_table.Entity.Genre;
import com.example.movie_table.dto.ActorUpdateResponseDto;
import com.example.movie_table.dto.GenreUpdateResponseDto;
import com.example.movie_table.service.GenreService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        Genre createGenre = genreService.createGenre(genre);
        return new ResponseEntity<>(createGenre, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Genre genre = (Genre)genreService.getGenreById(id).orElseThrow();
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ActorUpdateResponseDto> updateGenreById(@PathVariable Long id, @RequestBody Genre genre) {
        GenreUpdateResponseDto updatedGenre = genreService.updateGenreById(id, genre);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenreById(@PathVariable Long id) {
        genreService.deleteGenreById(id);
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.NO_CONTENT);
    }
}
