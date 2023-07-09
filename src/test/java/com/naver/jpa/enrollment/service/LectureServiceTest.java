package com.naver.jpa.enrollment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.SubjectType;
import com.naver.jpa.enrollment.domain.Address;
import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.dto.LectureRequest;
import com.naver.jpa.enrollment.dto.LectureResponse;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.fixture.LectureCreator;
import com.naver.jpa.enrollment.fixture.ProfessorCreator;
import com.naver.jpa.enrollment.fixture.SubjectCreator;
import com.naver.jpa.enrollment.repository.LectureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LectureServiceTest {

    @Mock
    private SubjectResolver subjectResolver;
    @Mock
    private ProfessorResolver professorResolver;
    @Mock
    private LectureRepository lectureRepository;

    @InjectMocks
    private LectureService lectureService;

    @Test
    public void testGetOne_should_be_throw_exception_when_lecture_does_not_exist() {

        //Given
        final long invalidLectureId = -1l;
        given(lectureRepository.findById(invalidLectureId)).willReturn(Optional.empty());

        //When
        assertThrows(ResourceNotFoundException.class, () -> {
            lectureService.getOne(invalidLectureId);
        });
    }

    @Test
    public void testGetOne_should_be_return_lecture_successfully_when_lecture_exists() {
        //Given
        final long validLectureId = 1l;

        Lecture expected = LectureCreator.create(validLectureId, "lectureName", 10, 3, 100);
        given(lectureRepository.findById(validLectureId)).willReturn(Optional.of(expected));

        //When
        LectureResponse actual = lectureService.getOne(validLectureId);

        //Then
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getLectureDays(), actual.getLectureDays());
        assertEquals(expected.getLectureHourOfDay(), actual.getLectureHourOfDay());
        assertEquals(expected.getLectureName(), actual.getLectureName());
    }

    @Test
    public void testCreate_should_be_create_lecture_successfully() {
        //Given
        final long validLectureId = 1l;
        LectureRequest createRequest = LectureCreator.createRequest("lectureName", 10, 3, 100);
        Lecture expected = LectureCreator.create(validLectureId, createRequest.getLectureName(), createRequest.getLectureDays(), createRequest.getLectureHourOfDay(), createRequest.getFixedNumber());
        given(lectureRepository.save(any())).willReturn(expected);

        //When
        LectureResponse actual = lectureService.create(createRequest);

        //Then
        assertNotNull(actual);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getLectureName(), actual.getLectureName());
        assertEquals(expected.getLectureDays(), actual.getLectureDays());
        assertEquals(expected.getLectureHourOfDay(), actual.getLectureHourOfDay());
        assertEquals(expected.getLectureName(), actual.getLectureName());
    }

    @Test
    public void testEdit_should_be_create_lecture_successfully() {
        //Given
        final long validLectureId = 1l;
        LectureRequest expected = LectureCreator.createRequest("editLectureName", 15, 3, 100);
        Lecture savedLecture = LectureCreator.create(validLectureId,  "lectureName", 10, 3, 100);

        Subject subject = SubjectCreator.create(1l, "name", "description", SubjectType.MANDATORY);
        DomesticProfessor professor = ProfessorCreator.createDomesticProfessor(1l, "userId", "name", "email@naver.com", "mobile", Address.of("city", "street", "addressDetail", "zipcode"), Gender.MAIL, "identificationNumber");
        given(subjectResolver.findOne(any())).willReturn(subject);
        given(professorResolver.findProfessor(any())).willReturn(professor);
        given(lectureRepository.findById(validLectureId)).willReturn(Optional.of(savedLecture));
        given(lectureRepository.save(any())).willReturn(savedLecture);

        //When
        LectureResponse actual = lectureService.edit(validLectureId,expected);

        //Then
        assertNotNull(actual);
        assertEquals(expected.getLectureName(), actual.getLectureName());
        assertEquals(expected.getLectureDays(), actual.getLectureDays());
        assertEquals(expected.getLectureHourOfDay(), actual.getLectureHourOfDay());
        assertEquals(expected.getLectureName(), actual.getLectureName());
    }


}