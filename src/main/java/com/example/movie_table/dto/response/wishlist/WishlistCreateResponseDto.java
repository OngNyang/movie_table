package com.example.movie_table.dto.response.wishlist;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WishlistCreateResponseDto {
    private Long id;
//    private Movie movie;
//    private Member member;
    private long    movieId;
    private long    memberId;
}

