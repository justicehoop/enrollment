package com.naver.jpa.enrollment.fixture;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.SubjectType;
import com.naver.jpa.enrollment.domain.*;
import com.naver.jpa.enrollment.dto.LectureRequest;

public abstract class LectureCreator {
    public static LectureRequest createRequest(
            String lectureName,
            Integer lectureDays,
            Integer lectureHourOfDay,
            Integer fixedNumber) {
        return LectureRequest.builder()
                .lectureName(lectureName)
                .lectureDays(lectureDays)
                .lectureHourOfDay(lectureHourOfDay)
                .fixedNumber(fixedNumber)
                .professorId(1l)
                .subjectId(1l)
                .build();
    }

    public static Lecture create(Long id,
                                 String lectureName,
                                 Integer lectureDays,
                                 Integer lectureHourOfDay,
                                 Integer fixedNumber) {
        Subject subject = SubjectCreator.create(1l, "name", "description", SubjectType.MANDATORY);
        DomesticProfessor professor = ProfessorCreator.createDomesticProfessor(1l, "userId", "name", "email@naver.com", "mobile", Address.of("city", "street", "addressDetail", "zipcode"), Gender.MAIL, "identificationNumber");
        return create(id, lectureName, lectureDays, lectureHourOfDay, fixedNumber, professor, subject);
    }

    public static Lecture create(Long id,
                                 String lectureName,
                                 Integer lectureDays,
                                 Integer lectureHourOfDay,
                                 Integer fixedNumber,
                                 Professor professor,
                                 Subject subject) {
        return Lecture.builder()
                .id(id)
                .lectureName(lectureName)
                .lectureDays(lectureDays)
                .lectureHourOfDay(lectureHourOfDay)
                .fixedNumber(fixedNumber)
                .professor(professor)
                .subject(subject)
                .build();
    }
}
