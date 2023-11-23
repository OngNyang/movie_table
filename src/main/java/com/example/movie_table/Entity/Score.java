package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Score {
    @Id
    private Long id;
    private Long movieId;
    private Long userId;
    private int score;

}
