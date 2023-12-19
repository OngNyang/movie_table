package com.example.movie_table.dto.request.movie;

import com.example.movie_table.Entity.Actor;
import com.example.movie_table.Entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieCreateRequestDto {
//    private String title;
//    private LocalDate releaseDate;
//    private List<Actor> actors;
    private String      title;
    private LocalDate   releaseDate;
//    private List<String>  directorNameList;
    private String  directorName;
    private List<String>  actorNameList;
//    private List<String>  genreNameList;
    private String      genreName;
}
