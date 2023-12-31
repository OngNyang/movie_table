package com.example.movie_table.controller;


import com.example.movie_table.Entity.Wishlist;
import com.example.movie_table.dto.request.wishlist.WishlistCreateRequestDto;
import com.example.movie_table.dto.response.wishlist.WishlistCreateResponseDto;
import com.example.movie_table.dto.response.wishlist.WishlistDeleteResponseDto;
import com.example.movie_table.dto.response.wishlist.WishlistReadResponseDto;
import com.example.movie_table.dto.response.wishlist.WishlistUpdateResponseDto;
import com.example.movie_table.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies/{movie_id}/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping
    public ResponseEntity<WishlistCreateResponseDto> createWishlist(@RequestBody WishlistCreateRequestDto wishlistCreateRequestDto) {    //얘도 dto를 만들어서 받아야할까?
//        Wishlist createdWishlist = wishlistService.createWishlist(wishlist);
//        return new ResponseEntity<>(createdWishlist, HttpStatus.CREATED);
        WishlistCreateResponseDto createdWishlist = wishlistService.createWishlist(wishlistCreateRequestDto);
        return new ResponseEntity<>(createdWishlist, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WishlistReadResponseDto> getWishlistById(@PathVariable Long id) {
        WishlistReadResponseDto wishlist = wishlistService.getWishlistById(id);
        return new ResponseEntity<>(wishlist, HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<WishlistUpdateResponseDto> updateWishlistById(@PathVariable Long id, @RequestBody Wishlist wishlist) {
//        WishlistUpdateResponseDto updatedWishlist = wishlistService.updateWishlistById(id, wishlist);
//        return new ResponseEntity<>(updatedWishlist, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WishlistDeleteResponseDto> deleteWishlistById(@PathVariable Long id) {
        wishlistService.deleteWishlistById(id);
        return new ResponseEntity<>(new WishlistDeleteResponseDto("삭제되었습니다.") , HttpStatus.NO_CONTENT);
    }

}
