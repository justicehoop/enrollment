package com.naver.jpa.enrollment.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.naver.jpa.enrollment.domain.Enrollment;
import com.naver.jpa.enrollment.domain.Lecture;

public interface EnrollmentRepositoryCustom {
  Page<Enrollment> findAll(Long studentId, EnrollmentSearchRequest enrollmentSearchRequest, Pageable pageable);

  long countByLecture(Lecture lecture);
}
