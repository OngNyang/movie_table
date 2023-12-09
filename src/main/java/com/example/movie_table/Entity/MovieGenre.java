package com.example.movie_table.Entity;

import javax.persistence.*;

@Table(name="movie_genres")
@Entity
public class MovieGenre {
    @Id
    @Column(name = "movie_genres_id")
    private Long movie_genres_id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
