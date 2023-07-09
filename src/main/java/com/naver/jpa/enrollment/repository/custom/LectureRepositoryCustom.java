package com.naver.jpa.enrollment.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.dto.LectureSearchRequest;

public interface LectureRepositoryCustom {
  Page<Lecture> findAll(LectureSearchRequest lectureSearchRequest, Pageable pageable);
}
