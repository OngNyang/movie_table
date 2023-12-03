package com.example.movie_table.service;

import com.example.movie_table.Entity.Actor;
import com.example.movie_table.dto.ActorUpdateResponseDto;
import com.example.movie_table.dto.UpdateResponseDto;
import com.example.movie_table.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public ActorUpdateResponseDto updateActorById(Long id, Actor actor) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()) {
            actor.setId(id);
            actorRepository.save(actor);
        }
        return new ActorUpdateResponseDto(id, actor.getName());
    }

    public void deleteActorById(Long id) {
        actorRepository.deleteById(id);
    }
}
