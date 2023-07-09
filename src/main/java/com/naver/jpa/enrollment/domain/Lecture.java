package com.naver.jpa.enrollment.domain;

import java.time.DayOfWeek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter(AccessLevel.PACKAGE)
@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lectureName;
    @JoinColumn(name = "subject_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Subject subject;
    @JoinColumn(name = "professor_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Professor professor;

    @JoinColumn(name = "class_room_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ClassRoom classRoom;

    @Column(length = 3)
    private Integer fixedNumber;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    @Column(nullable = false, length = 5)
    private String startHourMin;
    @Column(nullable = false, length = 5)
    private String endHourMin;
    @Column(nullable = false, length = 3)
    private Integer lectureHourOfDay;
    @Column(nullable = false, length = 3)
    private Integer lectureDays;


    public boolean isExceed(long registeredNumber) {
        return fixedNumber < registeredNumber;
    }

    public Lecture edit(String lectureName,
                        Integer lectureDays,
                        Integer lectureHourOfDay,
                        Integer fixedNumber,
                        Professor professor,
                        Subject subject) {
        this.lectureName = lectureName;
        this.lectureDays = lectureDays;
        this.lectureHourOfDay = lectureHourOfDay;
        this.fixedNumber = fixedNumber;
        this.professor = professor;
        this.subject = subject;
        return this;
    }
}
