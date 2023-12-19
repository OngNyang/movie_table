package com.example.movie_table.dto.response.genre;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenreUpdateResponseDto {
    private Long   id;
    private String name;
}
