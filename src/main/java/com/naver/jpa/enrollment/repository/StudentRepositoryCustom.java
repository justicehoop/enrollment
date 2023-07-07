package com.naver.jpa.enrollment.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.naver.jpa.enrollment.domain.Student;
import com.naver.jpa.enrollment.dto.StudentSearchRequest;

public interface StudentRepositoryCustom {
  Student findByIdOrNull(Long id);

  Optional<Student> findOne(Long id);

  Page<Student> findAll(StudentSearchRequest studentSearchRequest, Pageable pageable);
}
