package com.naver.jpa.enrollment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.naver.jpa.enrollment.domain.Enrollment;
import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.repository.impl.EnrollmentSearchRequest;

public interface EnrollmentRepositoryCustom {
  Page<Enrollment> findAll(Long studentId, EnrollmentSearchRequest enrollmentSearchRequest, Pageable pageable);

  long countByLecture(Lecture lecture);
}
