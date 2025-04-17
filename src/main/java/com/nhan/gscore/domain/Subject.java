package com.nhan.gscore.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum Subject {
    MATH(1, "math", "Toán"),
    LITERATURE(2, "literature", "Ngữ văn"),
    FOREIGN_LANGUAGE(3, "foreign_language", "Ngoại ngữ"),
    PHYSICS(4, "physics", "Vật lý"),
    CHEMISTRY(5, "chemistry", "Hóa học"),
    BIOLOGY(6, "biology", "Sinh học"),
    HISTORY(7, "history", "Lịch sử"),
    GEOGRAPHY(8, "geography", "Địa lý"),
    CIVIC_EDUCATION(9, "civic_education", "GDCD");

    private final int id;
    private final String columnName;
    private final String displayName;

    Subject(int id, String columnName, String displayName) {
        this.id = id;
        this.columnName = columnName;
        this.displayName = displayName;
    }

    public static Subject fromId(int id) {
        for (Subject s : values()) {
            if (s.id == id) {
                return s;
            }
        }
        throw new IllegalArgumentException("No subject with id: " + id);
    }

    public static List<?> getAllSubject() {
        List<SubjectDTO> subjects = new ArrayList<>();

        for (Subject s : values()) {
            subjects.add(new SubjectDTO(s));
        }

        return subjects;
    }

    @Getter
    @Setter
    static private class SubjectDTO {
        private int id;
        private String columnName;
        private String displayName;

        public SubjectDTO(Subject subject) {
            this.id = subject.getId();
            this.columnName = subject.getColumnName();
            this.displayName = subject.getDisplayName();
        }
    }
}
