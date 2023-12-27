package com.example.movie_table.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="wishlist")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist {

//    @Column(name = "wishlist_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public static Wishlist createWishlist(Movie movie, Member member) {
        return Wishlist.builder()
                .movie(movie)
                .member(member)
                .build();
    }
}



//
//+ wishlist_id INT
//        + movie_id INT
//        + member_id INT