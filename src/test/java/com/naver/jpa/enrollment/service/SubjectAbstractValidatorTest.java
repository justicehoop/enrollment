package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.dto.SubjectRequest;
import com.naver.jpa.enrollment.fixture.SubjectCreator;
import com.naver.jpa.enrollment.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SubjectAbstractValidatorTest {

    @Mock
    private SubjectRepository subjectRepository;
    @InjectMocks
    private SubjectService.SubjectValidator subjectValidator;


    @Test
    public void testValidateForCreate_should_be_throw_when_name_is_duplicated() {
        //Given
        final String duplicatedName = "duplicatedName";
        SubjectRequest subjectRequest = SubjectCreator.createRequest(duplicatedName, "");

        given(subjectRepository.findByName(duplicatedName)).willReturn(Optional.of(SubjectCreator.createMandatory(1L, duplicatedName, "")));

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            subjectValidator.validateForCreate(subjectRequest);
        });
    }

    @Test
    public void testValidateForCreate_should_be_throw_nothing() {
        //Given
        final String notDuplicatedName = "newName";
        SubjectRequest subjectRequest = SubjectCreator.createRequest(notDuplicatedName, "");

        given(subjectRepository.findByName(notDuplicatedName)).willReturn(Optional.empty());

        //When && Then
        subjectValidator.validateForCreate(subjectRequest);
    }

    @Test
    public void testValidateForEdit_should_be_throw_IllegalArgumentException_when_name_is_duplicated() {
        //Given
        final String duplicatedName = "duplicatedName";
        SubjectRequest subjectRequest = SubjectCreator.createRequest(duplicatedName, "");
        Subject duplicatedSubject = SubjectCreator.createMandatory(1L, duplicatedName, "'");
        Subject owner = SubjectCreator.createMandatory(2L, duplicatedName, "'");
        given(subjectRepository.findByName(duplicatedName)).willReturn(Optional.of(duplicatedSubject));

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            subjectValidator.validateForEdit(subjectRequest, owner);
        });
    }

    @Test
    public void testValidateForEdit_should_be_throw_nothing_when_name_is_duplicated_and_mine() {
        //Given
        final String duplicatedName = "duplicatedName";
        SubjectRequest subjectRequest = SubjectCreator.createRequest(duplicatedName, "");
        Subject owner = SubjectCreator.createMandatory(1L, duplicatedName, "'");
        given(subjectRepository.findByName(duplicatedName)).willReturn(Optional.of(owner));

        //When & Then
        subjectValidator.validateForEdit(subjectRequest, owner);
    }


}
