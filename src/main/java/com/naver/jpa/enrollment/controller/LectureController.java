package com.naver.jpa.enrollment.controller;

import com.naver.jpa.enrollment.dto.LectureRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.naver.jpa.enrollment.dto.LectureResponse;
import com.naver.jpa.enrollment.dto.LectureSearchRequest;
import com.naver.jpa.enrollment.service.LectureService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/{id}")
    public LectureResponse getOne(@PathVariable("id") Long id) {
        return lectureService.getOne(id);
    }

    @GetMapping
    public Page<LectureResponse> getAll(LectureSearchRequest lectureSearchRequest, @PageableDefault Pageable pageable) {
        return lectureService.getAll(lectureSearchRequest, pageable);
    }

    @PostMapping
    public LectureResponse createLecture(@RequestBody LectureRequest lectureRequest) {
        return null;
    }

}
