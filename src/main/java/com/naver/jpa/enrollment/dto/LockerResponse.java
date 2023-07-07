package com.naver.jpa.enrollment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import com.naver.jpa.enrollment.domain.Locker;

@Builder
@AllArgsConstructor
@Getter
public class LockerResponse {
  private Long id;
  private String location;

  public static LockerResponse from(Locker locker) {
    return LockerResponse.builder()
      .id(locker.getId())
      .location(locker.getLocation())
      .build();
  }
}
