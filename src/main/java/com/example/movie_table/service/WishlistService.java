package com.example.movie_table.service;

import com.example.movie_table.Entity.Wishlist;
import com.example.movie_table.dto.WishlistUpdateResponseDto;
import com.example.movie_table.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishlistService {
    private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }


    public Wishlist createWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public Optional<Wishlist> getWishlistById(Long id) {
        return wishlistRepository.findById(id);
    }

    public WishlistUpdateResponseDto updateWishlistById(Long id, Wishlist wishlist) {
        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(id);
        if (wishlistOptional.isPresent()) {
            wishlist.setId(id);
            wishlistRepository.save(wishlist);
        }
        return new WishlistUpdateResponseDto(id, wishlist.getMember(), wishlist.getMovie());
    }

    public void deleteWishlistById(Long id) {
        wishlistRepository.deleteById(id);
    }
}
