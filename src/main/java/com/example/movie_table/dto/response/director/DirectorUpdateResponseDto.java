package com.example.movie_table.dto.response.director;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DirectorUpdateResponseDto {
    private Long id;
    private String name;
}
