package com.example.movie_table.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Wishlist {
    @Id
    @Column(name = "wishlist_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}

//
//+ wishlist_id INT
//        + movie_id INT
//        + member_id INT