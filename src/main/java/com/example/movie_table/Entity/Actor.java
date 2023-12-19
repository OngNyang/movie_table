package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Actor {
    @Id
    private Long        id;
    private String      name;
    private LocalDate   birthdate;
    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movies;
//    private List<Movie> movies;
}
