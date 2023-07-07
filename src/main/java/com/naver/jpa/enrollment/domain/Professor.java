package com.naver.jpa.enrollment.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.NationalType;

@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Setter(AccessLevel.PACKAGE)
@Getter
@Entity
@DiscriminatorColumn(name = "nationalType")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Professor {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Long id;
  @Column(nullable = false, length = 50)
  protected String userId;
  @Column(nullable = false, length = 50)
  protected String email;
  @Column(nullable = false, length = 30)
  protected String name;
  @Column(nullable = false, length = 20)
  protected String mobile;
  @Embedded
  protected Address address;
  @Enumerated(EnumType.STRING)
  protected Gender gender;
  @OneToMany(mappedBy = "professor")
  private Set<Lecture> lectures = new HashSet<>();

  public Professor edit(String email, String mobile, Address address, Gender gender) {
    this.email = email;
    this.mobile = mobile;
    this.address = address;
    this.gender = gender;
    return this;
  }

  public abstract NationalType getNationalType();
}
