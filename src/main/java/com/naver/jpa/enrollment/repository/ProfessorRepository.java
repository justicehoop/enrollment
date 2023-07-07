package com.naver.jpa.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naver.jpa.enrollment.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}