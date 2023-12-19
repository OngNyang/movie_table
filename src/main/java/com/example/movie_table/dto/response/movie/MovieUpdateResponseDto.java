package com.example.movie_table.dto.response.movie;

import com.example.movie_table.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieUpdateResponseDto {
    private Long            id;
    private String          title;
    private Director     director;
    private Genre genre;
    private List<MovieActor>     actors;
    private LocalDate releaseDate;
    private Double          averageRating;
}

