package com.example.movie_table.dto.response.wishlist;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class WishlistReadResponseDto {
        private Long id;
        private long    movie_id;
        private long    member_id;
//        private Movie movie;
//        private Member member;
}
