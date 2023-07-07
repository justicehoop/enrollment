package com.naver.jpa.enrollment.service;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.dto.LectureResponse;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.dto.LectureSearchRequest;
import com.naver.jpa.enrollment.repository.LectureRepository;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LectureService {

  private final LectureRepository lectureRepository;

  public Page<LectureResponse> getAll(LectureSearchRequest lectureSearchRequest, Pageable pageable) {
    Page<Lecture> page = lectureRepository.findAll(lectureSearchRequest, pageable);

    return new PageImpl<>(page.getContent()
      .stream()
      .map(lecture -> LectureResponse.from(lecture))
      .collect(Collectors.toList()), pageable, page.getTotalElements());
  }

  public LectureResponse getOne(Long id) {
    return LectureResponse.from(findOne(id));
  }

  private Lecture findOne(Long id) {
    return lectureRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException(String.format("student(id:%d) does not exist", id)));
  }
}
