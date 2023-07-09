package com.naver.jpa.enrollment.repository;

import com.naver.jpa.enrollment.IntegrationTestSupport;
import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.domain.Address;
import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.domain.ForeignerProfessor;
import com.naver.jpa.enrollment.domain.Professor;
import com.naver.jpa.enrollment.fixture.EntityCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@RequiredArgsConstructor
public class ProfessorRepositoryTest extends IntegrationTestSupport {
  @Autowired
  private EntityCreator entityCreator;
  @Autowired
  private ProfessorRepository professorRepository;

  private final Address dummyAddress = Address.of("seoul", "street", "addressDetail, ", "000-000");

  @Test
  public void testDomesticProfessorSaveAndFlush() {
    DomesticProfessor domesticProfessor = professorRepository.save(DomesticProfessor
      .builder()
      .userId("userId1")
      .address(dummyAddress)
      .email("test@naver.com")
      .name("name")
      .mobile("010-2222-2222")
      .identificationNumber("9111211201022")
      .gender(Gender.MAIL)
      .build());

    assertNotNull(domesticProfessor);
    assertEquals("test@naver.com", domesticProfessor.getEmail());
  }

  @Test
  public void testForeignerProcessorSaveAndFlush() {
    ForeignerProfessor professor = professorRepository.save(ForeignerProfessor
      .builder()
      .userId("userId2")
      .address(dummyAddress)
      .gender(Gender.MAIL)
      .email("test@naver.com")
      .mobile("010-2222-2221")
      .name("test")
      .countryCode("KR")
      .passportNumber("000011112222")
      .build());
    assertNotNull(professor);
    assertEquals("test@naver.com", professor.getEmail());
  }

  @Test
  public void testFindAll() {
    for (int i = 0; i < 1; i++) {
      entityCreator.createDomesticProfessor(dummyAddress, "testName" + i, "testName" + i, "test" + i + "@naver.com", "010-2222-444" + i, "999999120341" + i);
      entityCreator.createForeignerProfessor(dummyAddress, "testName" + i, "testName" + i, "test" + i + "@naver.com", "010-2222-444" + i, "999999120341" + i);
    }

    List<Professor> all = professorRepository.findAll();
    all.stream()
      .forEach(professor -> log.info("professor:{}", professor));

  }

}
