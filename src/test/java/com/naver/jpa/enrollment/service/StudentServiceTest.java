package com.naver.jpa.enrollment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naver.jpa.enrollment.domain.Student;
import com.naver.jpa.enrollment.dto.StudentCreateRequest;
import com.naver.jpa.enrollment.dto.StudentEditRequest;
import com.naver.jpa.enrollment.dto.StudentResponse;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.fixture.StudentCreator;
import com.naver.jpa.enrollment.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

  @Mock
  private StudentService.StudentValidator studentValidator;
  @Mock
  private StudentRepository studentRepository;

  @InjectMocks
  private StudentService studentService;

  @Test
  public void test_create_should_be_return_successfully() {

    //Given
    StudentCreateRequest studentCreateRequest = StudentCreator.makeCreateRequest("userId");
    Student student = StudentCreator.makeStudent(studentCreateRequest.getUserId(), "email@email.com");

    given(studentRepository.save(any())).willReturn(student);

    //When
    StudentResponse actual = studentService.create(studentCreateRequest);

    //Then
    assertNotNull(actual);
    assertEquals(student.getName(), actual.getName());
    assertEquals(student.getEmail(), actual.getEmail());

  }

  @Test
  public void test_edit_should_be_return_successfully() {

    //Given
    final long toEditId = 1l;
    StudentEditRequest studentEditRequest = StudentCreator.makeEditRequest("changedName", "changedEmail@email.com");
    Student student = StudentCreator.makeStudent(toEditId,"toChangeUserId", studentEditRequest.getName(), "email@email.com");

    given(studentRepository.findOne(toEditId)).willReturn(Optional.of(student));
    given(studentRepository.save(any())).willReturn(student);

    //When
    StudentResponse actual = studentService.edit(student.getId(),studentEditRequest);

    //Then
    assertNotNull(actual);
    assertEquals(student.getName(), actual.getName());
    assertEquals(student.getEmail(), actual.getEmail());

  }


  @Test
  public void test_edit_should_be_throw_IllegalException_when_user_does_not_exist() {

    //Given
    final long toEditId = 1l;
    StudentEditRequest studentEditRequest = StudentCreator.makeEditRequest("changedName", "changedEmail@email.com");
    Student student = StudentCreator.makeStudent(toEditId,"toChangeUserId", studentEditRequest.getName(), "email@email.com");

    given(studentRepository.findOne(toEditId)).willReturn(Optional.empty());

    //When
    assertThrows(ResourceNotFoundException.class, () -> {
      studentService.edit(student.getId(),studentEditRequest);
    });


  }


}