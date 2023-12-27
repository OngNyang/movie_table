package com.example.movie_table.dto.request.wishlist;

import lombok.Data;

@Data
public class WishlistCreateRequestDto {
    private String title;
    private String memberEmail;
}
