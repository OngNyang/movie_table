package com.example.movie_table.dto.response.score;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreCreateResponseDto {
    private Long id;
    private Member member;
    private Movie movie;
    private int score;
}
