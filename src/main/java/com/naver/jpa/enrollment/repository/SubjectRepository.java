package com.naver.jpa.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naver.jpa.enrollment.domain.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>, SubjectRepositoryCustom {
}
