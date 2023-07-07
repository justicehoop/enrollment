package com.naver.jpa.enrollment.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;

import com.naver.jpa.enrollment.domain.ForeignerProfessor;
import com.naver.jpa.enrollment.domain.Professor;

@Getter
public class ForeignerProfessorResponse extends ProfessorResponse {
  private String passportNumber;
  private String countryCode;

  @Component
  public static class ForeignerProfessorResponseFactory extends AbstractProfessorResponseFactory {
    @Override
    public ProfessorResponse createInternal(Professor professor) {
      ForeignerProfessor foreignerProfessor = (ForeignerProfessor)professor;
      ForeignerProfessorResponse response = new ForeignerProfessorResponse();
      response.passportNumber = foreignerProfessor.getPassportNumber();
      response.countryCode = foreignerProfessor.getCountryCode();
      return response;
    }

    @Override
    public boolean isSupportFor(Professor professor) {
      return professor instanceof ForeignerProfessor;
    }
  }

}
