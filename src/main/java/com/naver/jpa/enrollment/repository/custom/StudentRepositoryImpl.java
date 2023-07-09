package com.naver.jpa.enrollment.repository.custom;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;

import com.naver.jpa.enrollment.domain.QStudent;
import com.naver.jpa.enrollment.domain.Student;
import com.naver.jpa.enrollment.dto.StudentSearchRequest;

public class StudentRepositoryImpl extends QuerydslRepositorySupport implements StudentRepositoryCustom {
  private final QStudent student = QStudent.student;

  public StudentRepositoryImpl() {
    super(Student.class);
  }

  @Override
  public Student findByIdOrNull(Long id) {
    return from(student)
      .leftJoin(student.locker).fetchJoin()
      .where(student.id.eq(id))
      .fetchOne();
  }

  @Override
  public Optional<Student> findOne(Long id) {
    return Optional.ofNullable(from(student)
      .leftJoin(student.locker).fetchJoin()
      .where(student.id.eq(id))
      .fetchOne());
  }

  @Override
  public Page<Student> findAll(StudentSearchRequest studentSearchRequest, Pageable pageable) {
    JPQLQuery<Student> jpqlQuery = from(student)
      .leftJoin(student.locker).fetchJoin()
      .where(getWhereCondition(studentSearchRequest))
      .fetchAll();

    return new PageImpl<>(jpqlQuery.fetch(), pageable, jpqlQuery.fetchCount());
  }

  private Predicate getWhereCondition(StudentSearchRequest studentSearchRequest) {
    BooleanBuilder builder = new BooleanBuilder();

    if (studentSearchRequest.hasUserId()) {
      builder.and(student.userId.like(studentSearchRequest.getUserId() + "%"));
    }

    if (studentSearchRequest.hasEmail()) {
      builder.and(student.userId.like(studentSearchRequest.getEmail() + "%"));
    }

    if (studentSearchRequest.hasName()) {
      builder.and(student.userId.like(studentSearchRequest.getName() + "%"));
    }


    return builder.getValue();
  }

}
