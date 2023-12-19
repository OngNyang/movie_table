package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Director {
    @Id @Column(name = "director_id")
    private Long        id;
    private String      name;
}
