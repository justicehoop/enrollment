package com.naver.jpa.enrollment.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import com.naver.jpa.enrollment.code.SubjectType;
import com.naver.jpa.enrollment.domain.Subject;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SubjectResponse {
  private Long id;
  private String name;
  private String description;
  private Float credit;
  private SubjectType subjectType;

  public static SubjectResponse from(Subject subject) {
    return SubjectResponse.builder()
      .id(subject.getId())
      .name(subject.getName())
      .description(subject.getDescription())
      .credit(subject.getCredit())
      .subjectType(subject.getSubjectType())
      .build();
  }
}
