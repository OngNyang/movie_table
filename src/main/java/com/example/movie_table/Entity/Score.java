package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Score {
    @Id
    @Column(name = "score_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private int score;
}

//        + star_meter_id INT
//        + movie_id INT
//        + member_id INT
//        + score INT
