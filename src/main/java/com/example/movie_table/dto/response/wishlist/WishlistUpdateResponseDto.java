package com.example.movie_table.dto.response.wishlist;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WishlistUpdateResponseDto {
    private Long id;
    private Member member;
    private Movie movie;
}
