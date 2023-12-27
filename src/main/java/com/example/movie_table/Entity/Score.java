package com.example.movie_table.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="score")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private int score;

    public static Score createScore(Movie movie, Member member, int score) {
        return Score.builder()
                .movie(movie)
                .member(member)
                .score(score)
                .build();
    }

}

//        + star_meter_id INT
//        + movie_id INT
//        + member_id INT
//        + score INT
