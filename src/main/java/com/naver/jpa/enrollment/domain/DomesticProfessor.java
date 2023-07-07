package com.naver.jpa.enrollment.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.NationalType;

@NoArgsConstructor
@Setter(AccessLevel.PACKAGE)
@Getter
@Entity
@DiscriminatorValue(NationalType.Values.DOMESTIC)
public class DomesticProfessor extends Professor {
  @Column(length = 30)
  private String identificationNumber;

  @Builder
  public DomesticProfessor(Long id, String userId, String email, String name, String mobile, Address address, Gender gender, Set<Lecture> lectures, String identificationNumber) {
    super(id, userId,email,name,mobile,address,gender,lectures);
    this.identificationNumber = identificationNumber;
  }

  @Override
  public NationalType getNationalType() {
    return NationalType.DOMESTIC;
  }
}
