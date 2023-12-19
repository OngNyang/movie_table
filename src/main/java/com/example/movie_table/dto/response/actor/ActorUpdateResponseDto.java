package com.example.movie_table.dto.response.actor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActorUpdateResponseDto {
    private Long id;
    private String name;
}
