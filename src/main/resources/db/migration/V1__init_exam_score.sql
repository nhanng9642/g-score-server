CREATE TABLE exam_score (
    candidate_id BIGINT PRIMARY KEY,
    math DOUBLE,
    literature DOUBLE,
    foreign_language DOUBLE,
    physics DOUBLE,
    chemistry DOUBLE,
    biology DOUBLE,
    history DOUBLE,
    geography DOUBLE,
    civic_education DOUBLE,
    language_code VARCHAR(10)
);

LOAD DATA LOCAL INFILE 'data.csv'
    INTO TABLE exam_score
    FIELDS TERMINATED BY ','
    LINES TERMINATED BY '\n'
    IGNORE 1 ROWS
    (@candidate_id, @math, @literature, @foreign_language, @physics, @chemistry, @biology, @history, @geography, @civic_education, @language_code)
    SET
        candidate_id = @candidate_id,
        math = NULLIF(@math, ''),
        literature = NULLIF(@literature, ''),
        foreign_language = NULLIF(@foreign_language, ''),
        physics = NULLIF(@physics, ''),
        chemistry = NULLIF(@chemistry, ''),
        biology = NULLIF(@biology, ''),
        history = NULLIF(@history, ''),
        geography = NULLIF(@geography, ''),
        civic_education = NULLIF(@civic_education, ''),
        language_code = NULLIF(@language_code, '');