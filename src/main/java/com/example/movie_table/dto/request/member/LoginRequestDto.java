package com.example.movie_table.dto.request.member;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
