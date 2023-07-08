package com.naver.jpa.enrollment.dto;

import lombok.*;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.NationalType;

@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class ProfessorEditRequest {
  private NationalType nationalType;

  private String name;
  private String email;
  private String mobile;
  private AddressDto address;
  private Gender gender;

  private String identificationNumber;

  private String passportNumber;
  private String countryCode;
  private AddressDto homeAddress;

}
