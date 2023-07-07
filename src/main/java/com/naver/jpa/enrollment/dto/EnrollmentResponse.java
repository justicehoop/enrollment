package com.naver.jpa.enrollment.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import com.naver.jpa.enrollment.domain.Enrollment;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class EnrollmentResponse {
  private StudentResponse student;
  private LectureResponse lecture;
  private Float grade;

  public static EnrollmentResponse from(Enrollment enrollment) {
    return EnrollmentResponse
      .builder()
      .student(StudentResponse.from(enrollment.getStudent()))
      .lecture(LectureResponse.from(enrollment.getLecture()))
      .grade(enrollment.getGrade())
      .build();
  }
}
