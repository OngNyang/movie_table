package com.example.movie_table.dto.response.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberCreateResponseDto {
    private Long id;
    private String name;
    private String email;
}
