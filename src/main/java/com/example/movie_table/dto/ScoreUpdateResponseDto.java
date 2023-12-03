package com.example.movie_table.dto;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreUpdateResponseDto {
    private Long id;
    private Member member;
    private Movie movie;
}
