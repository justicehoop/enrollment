package com.naver.jpa.enrollment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class LectureRequest {
    private String lectureName;
    private Long subjectId;
    private Long professorId;
    private Integer fixedNumber;
    private DayOfWeek dayOfWeek;
    private String startHourMin;
    private String endHourMin;
    private Integer lectureHourOfDay;
    private Integer lectureDays;
}
