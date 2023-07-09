package com.naver.jpa.enrollment.dto;

import java.time.DayOfWeek;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.naver.jpa.enrollment.domain.Lecture;

@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LectureResponse {
    private Long id;
    private String lectureName;
    private SubjectResponse subject;
    private ProfessorResponse professor;
    private Integer fixedNumber;
    private DayOfWeek dayOfWeek;
    private String startHourMin;
    private String endHourMin;
    private Integer lectureHourOfDay;
    private Integer lectureDays;

    public static LectureResponse from(Lecture lecture) {
        return LectureResponse.builder()
                .id(lecture.getId())
                .lectureName(lecture.getLectureName())
                .subject(SubjectResponse.from(lecture.getSubject()))
                .professor(ProfessorResponse.from(lecture.getProfessor()))
                .fixedNumber(lecture.getFixedNumber())
                .dayOfWeek(lecture.getDayOfWeek())
                .startHourMin(lecture.getStartHourMin())
                .endHourMin(lecture.getEndHourMin())
                .lectureHourOfDay(lecture.getLectureHourOfDay())
                .lectureDays(lecture.getLectureDays())
                .build();
    }
}
