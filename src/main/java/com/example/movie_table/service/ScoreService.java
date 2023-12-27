package com.example.movie_table.service;

import com.example.movie_table.Entity.Member;
import com.example.movie_table.Entity.Movie;
import com.example.movie_table.Entity.Score;
import com.example.movie_table.dto.request.score.ScoreCreateRequestDto;
import com.example.movie_table.dto.request.score.ScoreUpdateRequestDto;
import com.example.movie_table.dto.response.score.ScoreCreateResponseDto;
import com.example.movie_table.dto.response.score.ScoreReadResponseDto;
import com.example.movie_table.dto.response.score.ScoreUpdateResponseDto;
import com.example.movie_table.repository.MemberRepository;
import com.example.movie_table.repository.MovieRepository;
import com.example.movie_table.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final MovieRepository movieRepository;
    private final MemberRepository memberRepository;

//    @Autowired
//    public ScoreService(ScoreRepository scoreRepository) {
//
//        this.scoreRepository = scoreRepository;
//
//    }


//    public ScoreCreateResponseDto createScore(Score score) {
//        scoreRepository.save(score);
//        return new ScoreCreateResponseDto(score.getId(), score.getMember(), score.getMovie(), score.getScore());
////        return scoreRepository.save(score);
//    }

    public ScoreCreateResponseDto createScore(ScoreCreateRequestDto scoreDto) {
        Movie   movie = movieRepository.findById(scoreDto.getMovieId()).orElseThrow();
        Member  member = memberRepository.findById(scoreDto.getUserId()).orElseThrow();
        Score   score = Score.createScore(movie, member, scoreDto.getRating());
        scoreRepository.save(score);
        return new ScoreCreateResponseDto(score.getId(), score.getMember().getId() , score.getMovie().getId(), score.getScore());
//        return scoreRepository.save(score);
    }

    public ScoreReadResponseDto getScoreById(Long id) {
        Score score = scoreRepository.findById(id).orElseThrow();
        return new ScoreReadResponseDto(score.getId(), score.getMovie().getId(), score.getMember().getId(),  score.getScore());
//        return scoreRepository.findById(id);
    }

    public ScoreUpdateResponseDto updateScoreById(Long id, ScoreUpdateRequestDto scoreDto) {
        Optional<Score> scoreOptional = scoreRepository.findById(id);
        if (scoreOptional.isPresent()) {
//            score.setId(id);
//            scoreRepository.save(score);
            scoreOptional.get().setScore(scoreDto.getRating());
            scoreRepository.save(scoreOptional.get());
        }
//        return new ScoreUpdateResponseDto(id, score.getMember(), score.getMovie());
        return new ScoreUpdateResponseDto(id);
    }

    public void deleteScoreById(Long id) {
        scoreRepository.deleteById(id);
    }
}
