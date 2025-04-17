package com.nhan.gscore.controller;

import com.nhan.gscore.domain.Score;
import com.nhan.gscore.dto.response.BaseResponse;
import com.nhan.gscore.service.ScoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/score")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{candidateId}")
    public BaseResponse<Score> getScore(@PathVariable Long candidateId) {
        return BaseResponse.of(scoreService.getScore(candidateId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{subjectId}/report")
    public BaseResponse<?> getStatistic(@PathVariable int subjectId) {
        return BaseResponse.of(scoreService.getStatistic(subjectId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/group/A")
    public BaseResponse<?> getTop(@RequestParam(defaultValue = "10") int limit) {
        return BaseResponse.of(scoreService.getTopScoreGroupA(limit));
    }
}
