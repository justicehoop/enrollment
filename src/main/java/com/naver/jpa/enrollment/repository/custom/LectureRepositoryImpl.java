package com.naver.jpa.enrollment.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;

import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.domain.QLecture;
import com.naver.jpa.enrollment.dto.LectureSearchRequest;

public class LectureRepositoryImpl extends QuerydslRepositorySupport implements LectureRepositoryCustom {
  private final QLecture lecture = QLecture.lecture;

  public LectureRepositoryImpl() {
    super(Lecture.class);
  }

  @Override
  public Page<Lecture> findAll(LectureSearchRequest lectureSearchRequest, Pageable pageable) {
    JPQLQuery<Lecture> jpqlQuery = from(lecture)
      .innerJoin(lecture.professor).fetchJoin()
      .where(getSearchCondition(lectureSearchRequest))
      .fetchAll();
    return new PageImpl<>(jpqlQuery.fetch(), pageable, jpqlQuery.fetchCount());
  }

  private Predicate getSearchCondition(LectureSearchRequest lectureSearchRequest) {
    BooleanBuilder builder = new BooleanBuilder();

    if (lectureSearchRequest.hasLectureName()) {
      builder.and(lecture.lectureName.like(lectureSearchRequest.getLectureName() + "%"));
    }

    if (lectureSearchRequest.hasProfessName()) {
      builder.and(lecture.professor.name.like(lectureSearchRequest.getLectureName() + "%"));
    }

    return builder.getValue();
  }
}
