package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Director {
    @Id
    private Long        id;
    private String      name;
}
