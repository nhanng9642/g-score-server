package com.nhan.gscore.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exam_score")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score {

    @Id
    @Column(name = "candidate_id")
    private String candidateId;

    @Column(name = "math")
    private Double math;

    @Column(name = "literature")
    private Double literature;

    @Column(name = "foreign_language")
    private Double foreignLanguage;

    @Column(name = "physics")
    private Double physics;

    @Column(name = "chemistry")
    private Double chemistry;

    @Column(name = "biology")
    private Double biology;

    @Column(name = "history")
    private Double history;

    @Column(name = "geography")
    private Double geography;

    @Column(name = "civic_education")
    private Double civicEducation;

    @Column(name = "language_code")
    private String languageCode;
}
