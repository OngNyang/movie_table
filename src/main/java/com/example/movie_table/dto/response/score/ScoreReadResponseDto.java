package com.example.movie_table.dto.response.score;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreReadResponseDto {
    private Long id;
    private long movieId;
    private long memberId;
//    private Movie movie;
//    private Member member;
    private int score;
}
