package com.naver.jpa.enrollment.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor()
@Getter
@Setter(AccessLevel.PACKAGE)
@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String userId;

  @NonNull
  @Column(length = 30, nullable = false)
  private String name;
  @NonNull
  @Column(length = 25, nullable = false)
  private String password;

  @Column(length = 30)
  private String identificationNumber;
  @NonNull
  @Column(length = 30, nullable = false)
  private String email;
  @NonNull
  @Column(length = 30, nullable = false)
  private String dayOfBirth;
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "owner"
    , cascade = {CascadeType.PERSIST, CascadeType.MERGE}
  )
  private Locker locker;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "INTEREST_LECTURE",
    joinColumns = @JoinColumn(name = "STUDENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "LECTURE_ID"))
  private Set<Lecture> interestLectures = new HashSet<>();

  @OneToMany(mappedBy = "enrollmentKey.student")
  private Set<Enrollment> enrollments = new HashSet<>();

  @Builder(builderMethodName= "createBuilder")
  public Student(Long id, String userId, @NonNull String name, @NonNull String password, String identificationNumber, @NonNull String email, @NonNull String dayOfBirth) {
    this.id = id;
    this.userId = userId;
    this.name = name;
    this.password = password;
    this.identificationNumber = identificationNumber;
    this.email = email;
    this.dayOfBirth = dayOfBirth;
  }

  public Student edit(String name, String email,String password,  String dayOfBirth) {
    this.name = name;
    this.email = email;
    this.dayOfBirth = dayOfBirth;
    return this;
  }

  public Student assignLocker(Locker locker) {
    this.locker = locker;
    this.locker.assignOwner(this);
    return this;
  }

  public Student addInterestLecture(Lecture lecture) {
    if (!interestLectures.contains(lecture)) {
      this.interestLectures.add(lecture);
    }
    return this;
  }

  public boolean isSameOf(Student owner) {
    return this.equals(owner);
  }
}
