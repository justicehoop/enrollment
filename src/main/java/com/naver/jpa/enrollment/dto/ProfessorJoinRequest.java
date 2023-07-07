package com.naver.jpa.enrollment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.NationalType;
import com.naver.jpa.enrollment.domain.Address;
import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.domain.ForeignerProfessor;
import com.naver.jpa.enrollment.domain.Professor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorJoinRequest {
  private NationalType nationalType;
  private String userId;
  private String name;
  private String email;
  private String mobile;
  private AddressDto address;
  private Gender gender;

  private String identificationNumber;

  private String passportNumber;
  private String countryCode;
  private AddressDto homeAddress;

  public boolean isDomestic() {
    return nationalType == NationalType.DOMESTIC;
  }

  public Professor toProfessor() {
    if (isDomestic()) {
      return toDomesticProfessor();
    }

    return toForeignerProfessor();
  }

  private Professor toDomesticProfessor() {
    return DomesticProfessor.builder()
      .userId(userId)
      .name(name)
      .email(email)
      .mobile(mobile)
      .address(Address.of(address.getCity(), address.getStreet(), address.getAddressDetail(), address.getZipcode()))
      .gender(gender)
      .identificationNumber(identificationNumber)
      .build();
  }

  private Professor toForeignerProfessor() {
    return ForeignerProfessor.builder()
      .userId(userId)
      .name(name)
      .email(email)
      .mobile(mobile)
      .address(Address.of(address.getCity(), address.getStreet(), address.getAddressDetail(), address.getZipcode()))
      .gender(gender)
      .passportNumber(passportNumber)
      .homeAddress(homeAddress.toAddress())
      .countryCode(countryCode)
      .build();
  }
}
