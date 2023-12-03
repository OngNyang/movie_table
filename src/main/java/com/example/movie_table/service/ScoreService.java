package com.example.movie_table.service;

import com.example.movie_table.Entity.Score;
import com.example.movie_table.dto.ScoreUpdateResponseDto;
import com.example.movie_table.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }


    public Score createScore(Score score) {
        return scoreRepository.save(score);
    }

    public Optional<Score> getScoreById(Long id) {
        return scoreRepository.findById(id);
    }

    public ScoreUpdateResponseDto updateScoreById(Long id, Score score) {
        Optional<Score> scoreOptional = scoreRepository.findById(id);
        if (scoreOptional.isPresent()) {
            score.setId(id);
            scoreRepository.save(score);
        }
        return new ScoreUpdateResponseDto(id, score.getMember(), score.getMovie());
    }

    public void deleteScoreById(Long id) {
        scoreRepository.deleteById(id);
    }
}
