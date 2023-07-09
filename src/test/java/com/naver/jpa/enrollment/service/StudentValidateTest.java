package com.naver.jpa.enrollment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naver.jpa.enrollment.dto.StudentCreateRequest;
import com.naver.jpa.enrollment.dto.StudentEditRequest;
import com.naver.jpa.enrollment.fixture.StudentCreator;
import com.naver.jpa.enrollment.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentValidateTest {
  @Mock
  private StudentRepository studentRepository;
  @InjectMocks
  private StudentService.StudentValidator studentValidator;


  @Test
  public void testValidateWhenCreate_should_be_throw_IllegalArgumentException_when_userId_was_duplicated() {

    //Given
    StudentCreateRequest createRequest = StudentCreator.makeCreateRequest("userId");
    given(studentRepository.findByUserId(createRequest.getUserId())).willReturn(StudentCreator.makeStudent(createRequest.getUserId(), "test@email.com"));


    //When
    assertThrows(IllegalArgumentException.class,()-> {
      studentValidator.validateWhenCreate(createRequest);
    });

  }


  @Test
  public void testValidateWhenCreate_should_be_throw_IllegalArgumentException() {
    //Given
    StudentEditRequest studentEditRequest = StudentCreator.makeEditRequest("test","test@email.com");
    given(studentRepository.findByEmail(studentEditRequest.getEmail())).willReturn(StudentCreator.makeStudent("test", studentEditRequest.getEmail()));

    assertThrows(IllegalArgumentException.class,()-> {
      studentValidator.validateWhenEdit(studentEditRequest, null);
    });
  }



}
