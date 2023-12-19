package com.example.movie_table.repository;

import com.example.movie_table.Entity.Actor;
import com.example.movie_table.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    Optional<Actor> findByName(String email);
}
