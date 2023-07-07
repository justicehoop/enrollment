package com.naver.jpa.enrollment.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Setter(AccessLevel.PACKAGE)
@Getter
@Entity
public class Locker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String location;

  @JoinColumn(name = "student_no")
  @OneToOne(fetch = FetchType.LAZY, optional = true)
  private Student owner;

  Locker assignOwner(Student owner) {
    if (this.owner != null) {
      throw new IllegalStateException("owner already exist.");
    }
    this.owner = owner;
    return this;
  }

  public static Locker of(String location) {
    Locker locker = new Locker();
    locker.setLocation(location);
    return locker;
  }

  public static Locker of(String location, Student owner) {
    Locker locker = new Locker();
    locker.setLocation(location);
    locker.setOwner(owner);
    return locker;
  }
}
