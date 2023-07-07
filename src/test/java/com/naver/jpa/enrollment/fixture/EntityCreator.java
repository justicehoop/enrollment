package com.naver.jpa.enrollment.fixture;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.SubjectType;
import com.naver.jpa.enrollment.domain.Address;
import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.domain.ForeignerProfessor;
import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.repository.ProfessorRepository;
import com.naver.jpa.enrollment.repository.SubjectRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class EntityCreator {
  private final SubjectRepository subjectRepository;

  public Subject createSubject(String name, String description, Float credit) {
    return subjectRepository.save(Subject.of(name, description, credit, SubjectType.MANDATORY));
  }

  private final ProfessorRepository professorRepository;

  public DomesticProfessor createDomesticProfessor(Address address,
    String userId,
    String name,
    String email,
    String mobile,
    String identificationNumber) {
    return professorRepository.save(DomesticProfessor
      .builder()
      .userId(userId)
      .address(address)
      .name(name)
      .email(email)
      .mobile(mobile)
      .identificationNumber(identificationNumber)
      .gender(Gender.MAIL)
      .build());
  }

  public ForeignerProfessor createForeignerProfessor(Address address,
    String userId,
    String name,
    String email,
    String mobile,
    String passportNumber) {
    return professorRepository.save(ForeignerProfessor
      .builder()
      .userId(userId)
      .address(address)
      .gender(Gender.MAIL)
      .name(name)
      .email(email)
      .mobile(mobile)
      .countryCode("KR")
      .passportNumber(passportNumber)
      .build());
  }

}
