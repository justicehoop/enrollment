package com.naver.jpa.enrollment.repository;

import com.naver.jpa.enrollment.IntegrationTestSupport;
import com.naver.jpa.enrollment.domain.Locker;
import com.naver.jpa.enrollment.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@Slf4j
public class StudentRepositoryTest extends IntegrationTestSupport {
  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void test_save_should_be_save_successfully() {
    Student student = Student.builder()
      .userId("userId")
      .name("test")
      .email("test@naver.com")
      .password("password")
      .dayOfBirth("20170501")
      .build();


    studentRepository.save(student);
    Optional<Student> testOptional = studentRepository.findOne(student.getId());
    assertTrue(testOptional.isPresent());
  }

  @Test
  public void test_save_should_be_save() {
    final String editName = "editName";
    final String editEmail = "editemail@naver.com";
    final String editDayBirth = "20170501";

    Student student = Student.builder()
      .userId("userId")
      .name("test")
      .email("test@naver.com")
      .dayOfBirth("20170501")
      .password("password")
      .build();
    studentRepository.save(student);

    Optional<Student> savedStudentOptional = studentRepository.findOne(student.getId());
    assertTrue(savedStudentOptional.isPresent());
    Student savedStudent = savedStudentOptional.get();
    //locker 할당
    savedStudent.assignLocker(Locker.of("512"));

    savedStudent.edit(editName, editEmail,"password", editDayBirth);
    Student editedStudent = studentRepository.saveAndFlush(savedStudent);


    assertEquals(editName,editedStudent.getName());
    assertEquals(editEmail,editedStudent.getEmail());
    assertEquals(editDayBirth,editedStudent.getDayOfBirth());
  }


}