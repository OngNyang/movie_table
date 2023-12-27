package com.example.movie_table.Entity;

import com.example.movie_table.dto.request.movie.MovieCreateRequestDto;
import com.example.movie_table.dto.request.movie.MovieUpdateRequestDto;
import com.example.movie_table.dto.response.movie.MovieUpdateResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long            id;
    private String          title;
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director    director;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    private Genre     genre;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<MovieActor>     actors;
    //    private List<Actor>     actors;
    private LocalDate       releaseDate;
    private Double          averageRating;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<Wishlist> wishlists;
    @OneToMany(mappedBy = "movie")
    private List<Score> scores;

    public MovieUpdateResponseDto toDto() {
        return new MovieUpdateResponseDto(this.id, this.title, this.director, this.genre, this.actors, this.releaseDate, this.averageRating);
    }


    public void setDirector(Director director) {
        this.director = director;
    }

    public static Movie createMovie(MovieCreateRequestDto dto) {
        return Movie.builder()
                .title(dto.getTitle())
                .releaseDate(dto.getReleaseDate())
//                .directors(new ArrayList<>())
                .actors(new ArrayList<>())
//                .genre(dto.getGenre)
                .build();
    }

    public static Movie createMovie(MovieUpdateRequestDto dto) {
        return Movie.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .releaseDate(dto.getReleaseDate())
//                .directors(new ArrayList<>())
                .actors(new ArrayList<>())
//                .genres(new ArrayList<>())
                .averageRating(dto.getAverageRating())
                .build();
    }

}

