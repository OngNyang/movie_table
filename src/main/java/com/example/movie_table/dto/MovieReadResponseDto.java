package com.example.movie_table.dto;

import com.example.movie_table.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieReadResponseDto {
    private Long            id;
    private String          title;
    private List<Director> directors;
    private List<Genre>     genres;
    private List<Actor>     actors;
    private LocalDate releaseDate;
    private Double          averageRating;
}
