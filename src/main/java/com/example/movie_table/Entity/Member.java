package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Member {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  name;
    private String  password;
    private String  email;
    private String  nickname;
    @OneToMany(mappedBy = "member")
    private List<Wishlist> wishlists;
    @OneToMany(mappedBy = "member")
    private List<Score> scores;
}
