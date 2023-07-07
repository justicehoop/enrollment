package com.naver.jpa.enrollment.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class Address {
  @Column(length = 30)
  private String city;
  @Column(length = 200)
  private String street;
  @Column(length = 200)
  private String addressDetail;
  @Column(length = 20)
  private String zipcode;
}
