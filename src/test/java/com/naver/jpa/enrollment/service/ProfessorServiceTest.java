package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.domain.Address;
import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.domain.Professor;
import com.naver.jpa.enrollment.dto.*;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.fixture.ProfessorCreator;
import com.naver.jpa.enrollment.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ProfessorServiceTest {

    @Mock
    private ProfessorValidator professorValidator;
    @Mock
    private ProfessorRepository professorRepository;
    @Spy
    private ProfessorResponseFactoryResolver professorResponseFactoryResolver = ProfessorResponseFactoryHelper.createResolver();

    @InjectMocks
    private ProfessorService professorService;

    @Test
    public void testJoin_should_be_save_successfully() {
        //Given
        ProfessorJoinRequest domesticProfessorJoinRequest = ProfessorCreator.createDomesticJoinRequest("userId", "name", "email@naver.com", "mobile", AddressDto.of("city", "street", "addressDetail", "zipcode"), Gender.MAIL, "identificationNumber");
        Professor domesticProfessor = domesticProfessorJoinRequest.toProfessor();
        given(professorRepository.save(domesticProfessor)).willReturn(domesticProfessor);

        //When
        ProfessorResponse actual = professorService.join(domesticProfessorJoinRequest);

        //Then
        log.info("professor:{}", actual);
        log.info("professorSimpleName:{}", actual.getClass().getSimpleName());
        assertEquals(domesticProfessorJoinRequest.getUserId(), actual.getUserId());
        assertEquals(domesticProfessorJoinRequest.getEmail(), actual.getEmail());
        assertEquals(domesticProfessorJoinRequest.getMobile(), actual.getMobile());
        assertEquals(domesticProfessorJoinRequest.getIdentificationNumber(), ((DomesticProfessorResponse) actual).getIdentificationNumber());
    }

    @Test
    public void testEdit_should_be_throw_ResourceNotFoundException_when_professor_does_not_exist() {
        //Given
        ProfessorJoinRequest domesticProfessorJoinRequest = ProfessorCreator.createDomesticJoinRequest("userId", "name", "email@naver.com", "mobile", AddressDto.of("city", "street", "addressDetail", "zipcode"), Gender.MAIL, "identificationNumber");
        given(professorRepository.findById(any())).willReturn(Optional.empty());

        //When & Then
        assertThrows(ResourceNotFoundException.class, () -> {
            professorService.edit(1L, null);
        });
    }

    @Test
    public void testEdit_should_be_edit_successfully() {
        //Given
        final Long savedProfessorId = 1L;
        ProfessorEditRequest domesticProfessorEditRequest = ProfessorCreator.createDomesticEditRequest("editName", "editEmail@naver.com", "editMobile", AddressDto.of("editCity", "street", "addressDetail", "zipcode"), Gender.MAIL, "editIdentificationNumber");
        DomesticProfessor savedProfessor = ProfessorCreator.createDomesticProfessor(savedProfessorId, "userId", "name", "email@naver.com", "mobile", Address.of("city", "street", "addressDetail", "zipcode"), Gender.MAIL, "identificationNumber");
        given(professorRepository.findById(any())).willReturn(Optional.of(savedProfessor));
        given(professorRepository.save(any())).willReturn(savedProfessor);

        //When
        ProfessorResponse actual = professorService.edit(savedProfessorId, domesticProfessorEditRequest);

        //Then
        assertEquals(domesticProfessorEditRequest.getAddress(), actual.getAddress());
        assertEquals(domesticProfessorEditRequest.getEmail(), actual.getEmail());
        assertEquals(domesticProfessorEditRequest.getMobile(), actual.getMobile());
        assertEquals(domesticProfessorEditRequest.getIdentificationNumber(), ((DomesticProfessorResponse) actual).getIdentificationNumber());

    }

    @Test
    public void testGetOne_should_be_return_professor_successfully() {
        //Given
        final Long savedProfessorId = 1L;
        DomesticProfessor savedProfessor = ProfessorCreator.createDomesticProfessor(savedProfessorId, "userId", "name", "email@naver.com", "mobile", Address.of("city", "street", "addressDetail", "zipcode"), Gender.MAIL, "identificationNumber");
        given(professorRepository.findById(any())).willReturn(Optional.of(savedProfessor));

        //When
        ProfessorResponse actual = professorService.getOne(savedProfessorId);

        //Then
        assertEquals(savedProfessor.getEmail(), actual.getEmail());
        assertEquals(savedProfessor.getMobile(), actual.getMobile());
        assertEquals(savedProfessor.getIdentificationNumber(), ((DomesticProfessorResponse) actual).getIdentificationNumber());
    }

    @Test
    public void testGetOne_should_throw_ResourceNotFoundException_when_professor_does_not_exist() {
        //Given
        final Long invalidProfessorId = -1L;
        given(professorRepository.findById(invalidProfessorId)).willReturn(Optional.empty());

        //When
        assertThrows(ResourceNotFoundException.class,() -> {
            professorService.getOne(invalidProfessorId);
        });
    }


}