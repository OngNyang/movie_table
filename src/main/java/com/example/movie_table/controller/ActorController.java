package com.example.movie_table.controller;

import com.example.movie_table.Entity.Actor;
import com.example.movie_table.dto.response.actor.ActorUpdateResponseDto;
import com.example.movie_table.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        Actor createActor = actorService.createActor(actor);
        return new ResponseEntity<>(createActor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        Actor actor = (Actor)actorService.getActorById(id).orElseThrow();
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorUpdateResponseDto> updateActorById(@PathVariable Long id, @RequestBody Actor actor) {
        ActorUpdateResponseDto updatedActor = actorService.updateActorById(id, actor);
        return new ResponseEntity<>(updatedActor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteActorById(@PathVariable Long id) {
        actorService.deleteActorById(id);
        return new ResponseEntity<>("삭제되었습니다.", HttpStatus.NO_CONTENT);
    }

}
