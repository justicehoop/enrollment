package com.naver.jpa.enrollment.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@EqualsAndHashCode(of = {"enrollmentKey"})
@NoArgsConstructor
@AllArgsConstructor
@Setter(AccessLevel.PACKAGE)
@Getter
@Entity
public class Enrollment {
  @EmbeddedId
  private EnrollmentKey enrollmentKey;
  private Float grade;

  public Student getStudent() {
    return enrollmentKey.getStudent();
  }

  public Lecture getLecture() {
    return enrollmentKey.getLecture();
  }

  public static Enrollment of(Student student, Lecture lecture) {
    return Enrollment.builder()
      .grade(null)
      .enrollmentKey(EnrollmentKey.of(student, lecture))
      .build();
  }

  @EqualsAndHashCode(of = {"student.id", "lecture.id"})
  @Embeddable
  @NoArgsConstructor
  @AllArgsConstructor(staticName = "of")
  @Getter
  public static class EnrollmentKey implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    private Lecture lecture;
  }
}
