package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Actor {
    @Id
    private Long        id;
    private LocalDate   birthdate;
}
