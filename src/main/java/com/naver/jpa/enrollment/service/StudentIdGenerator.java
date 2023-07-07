package com.naver.jpa.enrollment.service;

public interface StudentIdGenerator {
  String generate(int currentMax);
}
