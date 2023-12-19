package com.example.movie_table.Entity;

import com.example.movie_table.dto.request.member.MemberCreateRequestDto;
import com.example.movie_table.dto.request.member.MemberUpdateRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private String  password;
    private String  email;
    private String  nickname;
    @OneToMany(mappedBy = "member")
    private List<Wishlist> wishlists;
    @OneToMany(mappedBy = "member")
    private List<Score> scores;

    public static Member signup(MemberCreateRequestDto dto) {
//        Member member = new Member();
        return Member.builder()
                .name(dto.getName())
                .nickname(dto.getNickname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .wishlists(new ArrayList<>())
                .scores(new ArrayList<>())
                .build();       ////빌더 패턴
    }   //정적팩토리메서드

    public static Member createMember(MemberUpdateRequestDto dto) {
        return Member.builder()
                .name(dto.getName())
                .nickname(dto.getNickname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .wishlists(new ArrayList<>())
                .scores(new ArrayList<>())
                .build();       ////빌더 패턴
    }   //정적팩토리메서드

 }
