package com.naver.jpa.enrollment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentCreateRequest {
  private String userId;
  private String name;
  private String password1;
  private String password2;
  private String email;
  private String dayOfBirth;

}

