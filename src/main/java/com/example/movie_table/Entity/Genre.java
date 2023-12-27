package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Genre {
    @Id @Column(name = "genre_id")
    private Long        id;
    private String      name;
}
