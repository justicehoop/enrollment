package com.naver.jpa.enrollment.dto;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentSearchRequest {
  private String userId;
  private String name;
  private String email;

  public boolean hasUserId() {
    return StringUtils.hasText(userId);
  }

  public boolean hasName() {
    return StringUtils.hasText(name);
  }

  public boolean hasEmail() {
    return StringUtils.hasText(email);
  }

}
