package com.naver.jpa.enrollment.service.dummy;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.repository.ProfessorRepository;
import com.naver.jpa.enrollment.repository.StudentRepository;
import com.naver.jpa.enrollment.repository.SubjectRepository;

@Component
public class DummyCreator {

  @RequiredArgsConstructor
  public static class StudentCreator {

    private final StudentRepository studentRepository;

  }

  @RequiredArgsConstructor
  public static class SubjectCreator {
    private final SubjectRepository subjectREpository;

  }

  @RequiredArgsConstructor
  public static class ProfessorCreator {
    private final ProfessorRepository professorRepository;

  }
}
