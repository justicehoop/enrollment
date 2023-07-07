package com.naver.jpa.enrollment.service;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.domain.Professor;
import com.naver.jpa.enrollment.dto.ProfessorResponse;

@Component
@RequiredArgsConstructor
public class ProfessorResponseFactoryResolver {
  private final List<ProfessorResponse.AbstractProfessorResponseFactory> professorResponseFactories;

  public ProfessorResponse.AbstractProfessorResponseFactory resolve(Professor professor) {
    return professorResponseFactories.stream()
      .filter(factory -> factory.isSupportFor(professor))
      .findFirst()
      .orElseThrow(() ->
        new IllegalArgumentException(String.format("ProfessorResponseFactory can't be resolved for type(%s)", professor.getClass().getName())))
      ;
  }

}
