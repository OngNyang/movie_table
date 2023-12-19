package com.example.movie_table.repository;

import com.example.movie_table.Entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    Optional<Director> findByName(String directorName);
}
