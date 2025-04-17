package com.nhan.gscore.repository;

import com.nhan.gscore.dto.response.SubjectReport;

import java.util.List;

public interface CustomScoreRepository {
    List<SubjectReport> getScoreRangeStats(String subjectColumn);
}
