package com.naver.jpa.enrollment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import com.naver.jpa.enrollment.domain.Student;


@Getter
@Builder
@AllArgsConstructor
public class StudentResponse {
  private String name;
  private String email;
  private String dayOfBirth;

  public static StudentResponse from(Student student) {
    return StudentResponse.builder()
      .name(student.getName())
      .email(student.getEmail())
      .dayOfBirth(student.getDayOfBirth())
      .build();

  }
}
