package com.naver.jpa.enrollment.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.naver.jpa.enrollment.code.SubjectType;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Data
public class SubjectRequest {
  private String name;
  private String description;
  private Float credit;
  private SubjectType subjectType;
}
