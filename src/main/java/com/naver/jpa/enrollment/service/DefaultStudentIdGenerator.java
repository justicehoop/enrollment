package com.naver.jpa.enrollment.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultStudentIdGenerator implements StudentIdGenerator {
  @Override
  public String generate(int currentMax) {
    return String.format("%d%05d", LocalDate.now().getYear(), currentMax + 1);
  }
}
