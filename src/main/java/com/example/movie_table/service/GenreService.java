package com.example.movie_table.service;

import com.example.movie_table.Entity.Genre;
import com.example.movie_table.dto.GenreUpdateResponseDto;
import com.example.movie_table.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public GenreUpdateResponseDto updateGenreById(Long id, Genre genre) {
        Optional<Genre> genreOptional = genreRepository.findById(id);
        if (genreOptional.isPresent()) {
            genre.setId(id);
            genreRepository.save(genre);
        }
        return new GenreUpdateResponseDto(id, genre.getName());
    }

    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }
}
