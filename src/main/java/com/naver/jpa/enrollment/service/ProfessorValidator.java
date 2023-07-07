package com.naver.jpa.enrollment.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.code.NationalType;
import com.naver.jpa.enrollment.domain.ForeignerProfessor;
import com.naver.jpa.enrollment.domain.Professor;
import com.naver.jpa.enrollment.dto.ProfessorJoinRequest;
import com.naver.jpa.enrollment.repository.ProfessorRepository;

@RequiredArgsConstructor
@Component
public class ProfessorValidator {
  private final ProfessorRepository professorRepository;

  public void validate(ProfessorJoinRequest professorJoinRequest) {
  }

  public interface Validator {

    default void validate(ProfessorJoinRequest professorJoinRequest) {

      Professor professor = professorJoinRequest.toProfessor();
      validateValues(professor);

      this.validateInternal(professor);
    }

    default void validateValues(Professor professor) {
      if (!StringUtils.hasText(professor.getUserId())) {

      }

      if (!StringUtils.hasText(professor.getName())) {

      }

      if (!StringUtils.hasText(professor.getUserId())) {

      }

      if (!StringUtils.hasText(professor.getMobile())) {

      }

      if (professor.getGender() == null) {

      }
    }

    void validateInternal(Professor professor);

    boolean isSupportFor(Professor professor);
  }

  @Component
  public class DomesticProfessorValidator implements Validator {

    @Override
    public void validateInternal(Professor professor) {

    }

    @Override
    public boolean isSupportFor(Professor professor) {
      return professor.getNationalType() == NationalType.DOMESTIC;
    }
  }

  @Component
  public class ForeignerProfessorValidator implements Validator {

    @Override
    public void validateInternal(Professor professor) {
      ForeignerProfessor foreignerProfessor = (ForeignerProfessor)professor;
      StringUtils.hasText(foreignerProfessor.getPassportNumber());
    }

    @Override
    public boolean isSupportFor(Professor professor) {
      return professor.getNationalType() == NationalType.FOREIGNER;
    }
  }

}
