package com.example.movie_table.service;

import com.example.movie_table.Entity.Director;
import com.example.movie_table.dto.response.director.DirectorUpdateResponseDto;
import com.example.movie_table.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    public DirectorUpdateResponseDto updateDirectorById(long id, Director director) {
        Optional<Director> directorOptional = directorRepository.findById(id);
        if (directorOptional.isPresent()) {
            director.setId(id);
            directorRepository.save(director);
        }
        return new DirectorUpdateResponseDto(id, director.getName());
    }

    public void deleteDirectorById(Long id) {
        directorRepository.deleteById(id);
    }
}
