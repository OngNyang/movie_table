package com.example.movie_table.Entity;

import com.example.movie_table.dto.MovieUpdateResponseDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    private Long            id;
    private String          title;
    @OneToMany
    private List<Director>  directors;
    @OneToMany
    private List<Genre>     genres;
    @OneToMany
    private List<Actor>     actors;
    private LocalDate       releaseDate;
    private Double          averageRating;

    public MovieUpdateResponseDto toDto() {
        return new MovieUpdateResponseDto(this.id, this.title, this.directors, this.genres, this.actors, this.releaseDate, this.averageRating);
    }
}
