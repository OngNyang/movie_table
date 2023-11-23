package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Genre {
    @Id
    private Long        id;
    private String      name;
}
