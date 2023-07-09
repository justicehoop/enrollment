package com.naver.jpa.enrollment.repository;

import com.naver.jpa.enrollment.repository.custom.EnrollmentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naver.jpa.enrollment.domain.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Enrollment.EnrollmentKey>, EnrollmentRepositoryCustom {
}
