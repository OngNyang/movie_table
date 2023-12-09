package com.example.movie_table.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MovieCreateResponseDto {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private Double averageRating;
}
