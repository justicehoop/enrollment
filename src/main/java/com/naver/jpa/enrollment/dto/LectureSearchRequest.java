package com.naver.jpa.enrollment.dto;

import org.springframework.util.StringUtils;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LectureSearchRequest {
  private Long id;
  private String lectureName;
  private String professorName;

  public boolean hasId() {
    return id != null;
  }

  public boolean hasLectureName() {
    return StringUtils.hasText(lectureName);
  }

  public boolean hasProfessName() {
    return StringUtils.hasText(professorName);
  }
}
