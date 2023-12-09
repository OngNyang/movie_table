package com.example.movie_table.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberUpdateResponseDto {
    private Long id;
    private String name;
    private String email;
}
