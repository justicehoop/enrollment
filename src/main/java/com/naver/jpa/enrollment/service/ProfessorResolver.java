package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.Professor;

public interface ProfessorResolver {
    Professor findProfessor(Long id);
}
