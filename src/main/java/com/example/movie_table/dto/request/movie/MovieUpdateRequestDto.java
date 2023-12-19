package com.example.movie_table.dto.request.movie;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieUpdateRequestDto {
    private long    id;
    private String  title;
    private LocalDate releaseDate;
    private List<String> directorNameList;
    private List<String>  actorNameList;
    private List<String>  genreNameList;
    private Double      averageRating;
}
