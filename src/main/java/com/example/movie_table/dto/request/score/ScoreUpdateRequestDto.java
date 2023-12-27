package com.example.movie_table.dto.request.score;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreUpdateRequestDto {

    private long movieId;
    private long memberId;
    private int rating;
}
