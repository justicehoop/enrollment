package com.naver.jpa.enrollment.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NationalType {
  DOMESTIC(Values.DOMESTIC), FOREIGNER(Values.FOREIGNER);

  public static class Values {
    public static final String DOMESTIC = "DOMESTIC";
    public static final String FOREIGNER = "FOREIGNER";
  }

  private final String code;
}
