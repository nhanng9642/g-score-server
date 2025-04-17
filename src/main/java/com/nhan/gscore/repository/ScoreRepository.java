package com.nhan.gscore.repository;

import com.nhan.gscore.domain.Score;
import com.nhan.gscore.dto.response.SubjectReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>, CustomScoreRepository {
    @Query(
            value = """
            SELECT *
            FROM exam_score
            ORDER BY math + physics + chemistry DESC
            LIMIT :limit
        """,
            nativeQuery = true
    )
    List<Score> getTopByGroupA(@Param("limit") int limit);

}
