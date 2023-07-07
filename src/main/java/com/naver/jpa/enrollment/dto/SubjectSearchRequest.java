package com.naver.jpa.enrollment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectSearchRequest {
  private String name;
  private String description;
}
