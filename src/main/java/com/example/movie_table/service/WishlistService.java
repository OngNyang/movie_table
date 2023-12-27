package com.example.movie_table.service;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import com.example.movie_table.Entity.Wishlist;
import com.example.movie_table.dto.request.wishlist.WishlistCreateRequestDto;
import com.example.movie_table.dto.response.wishlist.WishlistCreateResponseDto;
import com.example.movie_table.dto.response.wishlist.WishlistReadResponseDto;
import com.example.movie_table.dto.response.wishlist.WishlistUpdateResponseDto;
import com.example.movie_table.repository.MemberRepository;
import com.example.movie_table.repository.MovieRepository;
import com.example.movie_table.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WishlistService {
//    private WishlistRepository wishlistRepository;
    private final WishlistRepository wishlistRepository;
    private final MemberRepository memberRepository;
    private final MovieRepository movieRepository;

//    @Autowired
//    public WishlistService(WishlistRepository wishlistRepository) {
//        this.wishlistRepository = wishlistRepository;
//    }


//    public WishlistCreateResponseDto createWishlist(Wishlist wishlist) {
//        wishlistRepository.save(wishlist);
//        return new WishlistCreateResponseDto(wishlist.getId(),  wishlist.getMovie(), wishlist.getMember());
////        return wishlistRepository.save(wishlist);
//    }

    public WishlistCreateResponseDto createWishlist(WishlistCreateRequestDto wishlistCreateRequestDto) {
        //request dto 를 Wishlist 타입으로 변환
        //id를 받을수는 없는것이니 name으로 받아서 찾아야함
        Movie movie = movieRepository.findByTitle(wishlistCreateRequestDto.getTitle());
        Member member = memberRepository.findByEmail(wishlistCreateRequestDto.getMemberEmail()).orElseThrow();
        Wishlist wishlist = Wishlist.createWishlist(movie, member);
        wishlistRepository.save(wishlist);
//        return new WishlistCreateResponseDto(wishlist.getId(),  wishlist.getMovie(), wishlist.getMember());
        return new WishlistCreateResponseDto(wishlist.getId(), wishlist.getMovie().getId(), wishlist.getMember().getId());
    }

    public WishlistReadResponseDto getWishlistById(Long id) {
        Wishlist wishlist = wishlistRepository.findById(id).orElseThrow();
        return new WishlistReadResponseDto(wishlist.getId(), wishlist.getMovie().getId(), wishlist.getMember().getId());
//        return wishlistRepository.findById(id);
    }

//    public WishlistUpdateResponseDto updateWishlistById(Long id, Wishlist wishlist) {
//        Optional<Wishlist> wishlistOptional = wishlistRepository.findById(id);
//        if (wishlistOptional.isPresent()) {
//            wishlist.setId(id);
//            wishlistRepository.save(wishlist);
//        }
//        return new WishlistUpdateResponseDto(id, wishlist.getMember(), wishlist.getMovie());
//    }

    public void deleteWishlistById(Long id) {
        wishlistRepository.deleteById(id);
    }
}
