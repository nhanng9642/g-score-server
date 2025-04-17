package com.nhan.gscore.service;

import com.nhan.gscore.domain.Score;
import com.nhan.gscore.domain.Subject;
import com.nhan.gscore.domain.exception.ScoreNotFoundException;
import com.nhan.gscore.dto.response.SubjectReport;
import com.nhan.gscore.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public Score getScore(Long candidateId) {
        return scoreRepository.findById(candidateId)
                .orElseThrow(() -> new ScoreNotFoundException(candidateId));
    }

    public List<SubjectReport> getStatistic(int subjectId) {
        String subjectName = Subject.fromId(subjectId).getColumnName();
        return scoreRepository.getScoreRangeStats(subjectName);
    }

    public List<Score> getTopScoreGroupA(int limit) {
        return scoreRepository.getTopByGroupA(limit);
    }
}
