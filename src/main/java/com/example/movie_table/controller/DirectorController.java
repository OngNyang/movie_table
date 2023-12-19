package com.example.movie_table.controller;

import com.example.movie_table.Entity.Director;
import com.example.movie_table.dto.response.director.DirectorUpdateResponseDto;
import com.example.movie_table.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/director")
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director) {
        Director createDirector = directorService.createDirector(director);
        return new ResponseEntity<>(createDirector, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        Director director = directorService.getDirectorById(id).orElse(null);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorUpdateResponseDto> updateDirectorById(@PathVariable Long id, @RequestBody Director director) {
        DirectorUpdateResponseDto updatedDirector = directorService.updateDirectorById(id, director);
        return new ResponseEntity<>(updatedDirector, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDirectorById(@PathVariable Long id) {
        directorService.deleteDirectorById(id);
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.NO_CONTENT);
    }





}
