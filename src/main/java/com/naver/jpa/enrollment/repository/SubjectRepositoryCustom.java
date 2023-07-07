package com.naver.jpa.enrollment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.dto.SubjectSearchRequest;

public interface SubjectRepositoryCustom {
  Page<Subject> findAll(SubjectSearchRequest subjectSearchRequest, Pageable pageable);
}
