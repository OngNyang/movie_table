package com.example.movie_table.controller;

import com.example.movie_table.dto.request.score.ScoreCreateRequestDto;
import com.example.movie_table.dto.request.score.ScoreUpdateRequestDto;
import com.example.movie_table.dto.response.score.ScoreCreateResponseDto;
import com.example.movie_table.dto.response.score.ScoreDeleteResponseDto;
import com.example.movie_table.dto.response.score.ScoreReadResponseDto;
import com.example.movie_table.dto.response.score.ScoreUpdateResponseDto;
import com.example.movie_table.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies/{movie_id}/ratings")
public class ScoreController {
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

//    @PostMapping
//    public ResponseEntity<ScoreCreateResponseDto> createScore(@RequestBody  Score score) {
//        ScoreCreateResponseDto createdScore = scoreService.createScore(score);
//        return new ResponseEntity<>(createdScore, HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<ScoreCreateResponseDto> createScore(@RequestBody ScoreCreateRequestDto scoreDto) {
        ScoreCreateResponseDto createdScore = scoreService.createScore(scoreDto);
        return new ResponseEntity<>(createdScore, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScoreReadResponseDto> getScoreById(@PathVariable Long id) {
        ScoreReadResponseDto score = scoreService.getScoreById(id);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScoreUpdateResponseDto> updateScoreById(@PathVariable Long id, @RequestBody ScoreUpdateRequestDto scoreDto) {
        ScoreUpdateResponseDto updatedScore = scoreService.updateScoreById(id, scoreDto);
        return new ResponseEntity<>(updatedScore, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ScoreDeleteResponseDto> deleteScoreById(@PathVariable Long id) {
        scoreService.deleteScoreById(id);
        return new ResponseEntity<>(new ScoreDeleteResponseDto("삭제되었습니다.") , HttpStatus.NO_CONTENT);
    }




}
