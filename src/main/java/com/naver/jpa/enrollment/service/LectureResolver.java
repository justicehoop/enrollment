package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.Lecture;

public interface LectureResolver {
    Lecture findOne(Long id);
}
