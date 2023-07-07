package com.naver.jpa.enrollment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentRegistrationRequest {
  private String name;
  private String password1;
  private String password2;
  private String email;
  private String dayOfBirth;
}
