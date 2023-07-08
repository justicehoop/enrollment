package com.naver.jpa.enrollment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

import com.naver.jpa.enrollment.code.SubjectType;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PACKAGE)
@Entity
public class Subject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, unique = true)
  private String name;
  @Column(length = 250)
  private String description;
  @Column(length = 2)
  private Float credit;
  @Enumerated(EnumType.STRING)
  private SubjectType subjectType;

  public Subject edit(String name, String description, Float credit, SubjectType subjectType) {
    this.name = name;
    this.description = description;
    this.credit = credit;
    this.subjectType = subjectType;
    return this;
  }

  public static Subject of(String name, String description, Float credit, SubjectType subjectType) {
    return new Subject(null, name, description, credit, subjectType);
  }

}
