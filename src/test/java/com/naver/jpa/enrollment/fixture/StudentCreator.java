package com.naver.jpa.enrollment.fixture;

import com.naver.jpa.enrollment.domain.Student;
import com.naver.jpa.enrollment.dto.StudentCreateRequest;
import com.naver.jpa.enrollment.dto.StudentEditRequest;

public abstract class StudentCreator {

    public static StudentCreateRequest makeCreateRequest(String userId) {
      return StudentCreateRequest
        .builder()
        .userId(userId)
        .name(userId)
        .password1(userId)
        .password2(userId)
        .email(userId + "@naver.com")
        .dayOfBirth("20170501")
        .build();
    }

    public static StudentEditRequest makeEditRequest(String name,String email) {
      return StudentEditRequest.builder()
        .name(name)
        .email(email)
        .password1(name)
        .password2(name)
        .build();
    }

    public static Student makeStudent(String userId, String email) {
      return Student.builder()
        .userId(userId)
        .name(userId)
        .password(userId)
        .email(email)
        .dayOfBirth("19700101")
        .build();
    }

  public static Student makeStudent(Long id, String userId, String name, String email) {
    return Student.builder()
      .id(id)
      .userId(userId)
      .name(name)
      .password(userId)
      .email(email)
      .dayOfBirth("19700101")
      .build();
  }

}
