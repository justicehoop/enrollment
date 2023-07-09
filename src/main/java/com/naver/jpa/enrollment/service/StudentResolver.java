package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.Student;

public interface StudentResolver {
    Student findOne(Long id);
}
