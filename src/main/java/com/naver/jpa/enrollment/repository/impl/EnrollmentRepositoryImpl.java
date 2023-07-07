package com.naver.jpa.enrollment.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

import com.naver.jpa.enrollment.domain.Enrollment;
import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.domain.QEnrollment;
import com.naver.jpa.enrollment.repository.EnrollmentRepositoryCustom;

public class EnrollmentRepositoryImpl extends QuerydslRepositorySupport implements EnrollmentRepositoryCustom {
  private final QEnrollment enrollment = QEnrollment.enrollment;

  public EnrollmentRepositoryImpl() {
    super(Enrollment.class);
  }

  @Override
  public Page<Enrollment> findAll(Long studentId, EnrollmentSearchRequest enrollmentSearchRequest, Pageable pageable) {
    JPQLQuery<Enrollment> jpqlQuery = from(enrollment)
      .innerJoin(enrollment.enrollmentKey.student).fetchJoin()
      .innerJoin(enrollment.enrollmentKey.lecture).fetchJoin()
      .where(enrollment.enrollmentKey.student.id.eq(studentId))
      .fetchAll();

    return new PageImpl<>(jpqlQuery.fetch(), pageable, jpqlQuery.fetchCount());
  }

  @Override
  public long countByLecture(Lecture lecture) {
    return from(enrollment)
      .where(enrollment.enrollmentKey.lecture.eq(lecture))
      .fetchCount();
  }

}
