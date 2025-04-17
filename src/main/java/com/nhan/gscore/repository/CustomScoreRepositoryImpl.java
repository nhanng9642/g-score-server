package com.nhan.gscore.repository;

import com.nhan.gscore.dto.response.SubjectReport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomScoreRepositoryImpl implements CustomScoreRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SubjectReport> getScoreRangeStats(String subjectColumn) {
        String sql = """
        SELECT 
            CASE 
                WHEN $COL >= 0 AND $COL < 4 THEN '0-4'
                WHEN $COL >= 4 AND $COL < 6 THEN '4-6'
                WHEN $COL >= 6 AND $COL < 8 THEN '6-8'
                WHEN $COL >= 8 AND $COL <= 10 THEN '8-10'
            END AS score_range,
            COUNT(*) AS total
        FROM exam_score
        WHERE $COL IS NOT NULL
        GROUP BY score_range
        ORDER BY score_range
    """.replace("$COL", subjectColumn);

        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();
        List<SubjectReport> reports = new ArrayList<>();

        for (Object[] row : results) {
            String category = (String) row[0];
            int count = ((Number) row[1]).intValue();
            reports.add(new SubjectReport(category, count));
        }

        return reports;
    }
}
