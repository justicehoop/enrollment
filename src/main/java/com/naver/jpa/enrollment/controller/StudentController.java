package com.naver.jpa.enrollment.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.naver.jpa.enrollment.dto.StudentCreateRequest;
import com.naver.jpa.enrollment.dto.StudentEditRequest;
import com.naver.jpa.enrollment.dto.StudentResponse;
import com.naver.jpa.enrollment.dto.StudentSearchRequest;
import com.naver.jpa.enrollment.service.StudentService;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/students")
@RestController
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/{id}")
  public StudentResponse getOne(@PathVariable("id") Long id) {
    return studentService.getOne(id);
  }

  @PostMapping
  public StudentResponse create(@RequestBody StudentCreateRequest studentCreateRequest) {
    return studentService.create(studentCreateRequest);
  }

  @PutMapping("/{id}")
  public StudentResponse edit(@PathVariable("id") Long id, StudentEditRequest studentEditRequest) {
    return studentService.edit(id, studentEditRequest);
  }

  @PutMapping("/{id}/locker/{lockerId}")
  public StudentResponse assignLocker(@PathVariable("id") Long id, @PathVariable("lockerId") Long lockerId) {
    return studentService.assignLocker(id, lockerId);
  }

  @GetMapping
  public Page<StudentResponse> getAll(StudentSearchRequest studentSearchRequest, @PageableDefault Pageable pageable) {
    return studentService.findAll(studentSearchRequest, pageable);
  }

}
