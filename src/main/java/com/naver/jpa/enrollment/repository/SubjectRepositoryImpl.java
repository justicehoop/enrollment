package com.naver.jpa.enrollment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;

import com.naver.jpa.enrollment.domain.QSubject;
import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.dto.SubjectSearchRequest;

public class SubjectRepositoryImpl extends QuerydslRepositorySupport implements SubjectRepositoryCustom {

  private final QSubject subject = QSubject.subject;

  public SubjectRepositoryImpl() {
    super(Subject.class);
  }

  @Override
  public Page<Subject> findAll(SubjectSearchRequest subjectSearchRequest, Pageable pageable) {
    JPQLQuery<Subject> jpqlQuery = from(subject)
      .where(getSearchCondition())
      .fetchJoin();
    return new PageImpl<>(jpqlQuery.fetch(), pageable, jpqlQuery.fetchCount());
  }

  private Predicate getSearchCondition() {
    BooleanBuilder builder = new BooleanBuilder();

    return builder.getValue();
  }
}
