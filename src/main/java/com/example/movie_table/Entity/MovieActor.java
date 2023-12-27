package com.example.movie_table.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="movie_actor")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "movie_actor_id")
    private Long movieActorId;
    //복합키를 생성하기 어려워서 매핑테이블에도 id를 넣어줌

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    public static MovieActor createMovieActor(Movie movie, Actor actor) {
        return MovieActor.builder()
                .actor(actor)
                .movie(movie)
                .build();
    }

}
