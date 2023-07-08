package com.naver.jpa.enrollment.dto;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.domain.Professor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Setter(AccessLevel.PACKAGE)
@Getter
public class DomesticProfessorResponse extends ProfessorResponse {
  protected String identificationNumber;

  @Builder(builderMethodName = "domesticProfessorBuilder")
  public DomesticProfessorResponse(
    Long id,
    String userId,
    String email,
    String mobile,
    AddressDto address,
    Gender gender,
    String identificationNumber) {
    super(id, userId, email, mobile, address, gender);
    this.identificationNumber = identificationNumber;
  }

  @Component
  public static class DomesticProfessorResponseFactory extends AbstractProfessorResponseFactory {
    @Override
    public ProfessorResponse createInternal(Professor professor) {
      DomesticProfessor domesticProfessor = (DomesticProfessor)professor;
      DomesticProfessorResponse response = new DomesticProfessorResponse();
      response.setIdentificationNumber(domesticProfessor.getIdentificationNumber());
      return response;
    }

    @Override
    public boolean isSupportFor(Professor professor) {
      return professor instanceof DomesticProfessor;
    }
  }

}
