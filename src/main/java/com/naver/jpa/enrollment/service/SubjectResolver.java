package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.Subject;

public interface SubjectResolver {
    Subject findOne(Long id);
}
