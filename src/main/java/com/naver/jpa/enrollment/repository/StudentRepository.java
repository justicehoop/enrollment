package com.naver.jpa.enrollment.repository;

import com.naver.jpa.enrollment.repository.custom.StudentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naver.jpa.enrollment.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom {
  Student findByEmail(String email);

  Student findByUserId(String userId);

}
