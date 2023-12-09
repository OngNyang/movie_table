package com.example.movie_table.Entity;

import javax.persistence.*;

@Table(name="movie_directors")
@Entity
public class MovieDirector {
    @Id
    @Column(name = "movie_director_id")
    private Long movie_director_id;
    //복합키를 생성하기 어려워서 매핑테이블에도 id를 넣어줌

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
}
