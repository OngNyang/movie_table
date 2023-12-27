package com.example.movie_table.dto.request.score;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreCreateRequestDto {
    private long    userId;
    private long    movieId;
    private int     rating;
}
