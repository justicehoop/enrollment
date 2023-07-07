package com.naver.jpa.enrollment.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.stereotype.Controller;

import com.naver.jpa.enrollment.dto.StudentCreateRequest;
import com.naver.jpa.enrollment.repository.StudentRepository;

@Controller
public class SubjectServiceTest {


  @Mock
  private StudentRepository studentRepository;
  @InjectMocks
  private StudentService studentService;

  public void testCreate() {
    studentService.create(StudentCreateRequest
      .builder()

      .build());
  }


}