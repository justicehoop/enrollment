package com.naver.jpa.enrollment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.naver.jpa.enrollment.dto.EnrollmentResponse;
import com.naver.jpa.enrollment.repository.custom.EnrollmentSearchRequest;
import com.naver.jpa.enrollment.service.EnrollmentService;

@Slf4j
@RequestMapping("/v1/enrollments")
@RequiredArgsConstructor
@RestController
public class EnrollmentController {

  private final EnrollmentService enrollmentService;

  @PostMapping
  public EnrollmentResponse register(Long studentId, Long lectureId) {
    return enrollmentService.register(studentId, lectureId);
  }

  @DeleteMapping("/{lectureId}")
  public void cancel(Long studentId,@PathVariable("lectureId") Long lectureId) {
    enrollmentService.cancel(studentId, lectureId);
  }
  @GetMapping
  public Page<EnrollmentResponse> getAll(Long studentId, EnrollmentSearchRequest enrollmentSearchRequest, @PageableDefault Pageable pageable) {
    return enrollmentService.getAll(studentId, enrollmentSearchRequest, pageable);
  }

}
