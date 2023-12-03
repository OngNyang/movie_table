package com.example.movie_table.repository;

import com.example.movie_table.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository  extends JpaRepository<Wishlist, Long> {
}
