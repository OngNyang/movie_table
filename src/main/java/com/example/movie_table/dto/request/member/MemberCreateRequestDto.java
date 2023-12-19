package com.example.movie_table.dto.request.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberCreateRequestDto {
    private String name;
    private String nickname;
    private String email;
    private String password;
}
