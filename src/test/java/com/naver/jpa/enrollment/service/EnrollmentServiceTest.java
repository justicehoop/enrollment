package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.Enrollment;
import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.domain.Student;
import com.naver.jpa.enrollment.dto.EnrollmentResponse;
import com.naver.jpa.enrollment.dto.LectureResponse;
import com.naver.jpa.enrollment.dto.StudentResponse;
import com.naver.jpa.enrollment.fixture.LectureCreator;
import com.naver.jpa.enrollment.fixture.StudentCreator;
import com.naver.jpa.enrollment.repository.EnrollmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class EnrollmentServiceTest {
    @Mock
    private StudentResolver studentResolver;
    @Mock
    private LectureResolver lectureResolver;
    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;


    @Test
    public void testRegister_should_be_successfully_when_registeredCount_is_less_than_fixedNumber() {
        final Long studentId = 1l;
        final Long lectureId = 1l;

        //Given
        Student student = StudentCreator.makeStudent("test", "test@naver.com");
        Lecture lecture = LectureCreator.create(lectureId, "testLecture", 8, 3, 70);

        given(studentResolver.findOne(studentId)).willReturn(student);
        given(lectureResolver.findOne(lectureId)).willReturn(lecture);
        given(enrollmentRepository.countByLecture(lecture)).willReturn(30l);
        given(enrollmentRepository.save(any())).willReturn(Enrollment.of(student,lecture));
        //When
        EnrollmentResponse actual = enrollmentService.register(studentId, lectureId);

        //Then
        assertNotNull(actual);
        assertEquals(LectureResponse.from(lecture).getId(),actual.getLecture().getId());
        assertEquals(StudentResponse.from(student).getId(),actual.getStudent().getId());
    }

    @Test
    public void testRegister_should_throw_IllegalStateException_when_registeredCount_is_bigger_than_fixedNumber() {
        final Long studentId = 1l;
        final Long lectureId = 1l;

        //Given
        Student student = StudentCreator.makeStudent("test", "test@naver.com");
        Lecture lecture = LectureCreator.create(lectureId, "testLecture", 8, 3, 70);

        given(studentResolver.findOne(studentId)).willReturn(student);
        given(lectureResolver.findOne(lectureId)).willReturn(lecture);
        given(enrollmentRepository.countByLecture(lecture)).willReturn(90l);
        //When
        assertThrows(IllegalStateException.class, () -> {
            enrollmentService.register(studentId, lectureId);
        });
    }

    @Test
    public void testDelete_should_be_delete_enrollment_successfully() {

        //Given
        final Long studentId = 1l;
        final Long lectureId = 1l;

        Student student = StudentCreator.makeStudent("test", "test@naver.com");
        Lecture lecture = LectureCreator.create(lectureId, "testLecture", 8, 3, 70);
        Enrollment expected = Enrollment.of(student, lecture);

        given(studentResolver.findOne(studentId)).willReturn(student);
        given(lectureResolver.findOne(lectureId)).willReturn(lecture);
        given(enrollmentRepository.findById(Enrollment.EnrollmentKey.of(student, lecture))).willReturn(Optional.of(expected));

        //When
        enrollmentService.cancel(studentId,lectureId);

        //Then
        verify(enrollmentRepository, times(1)).delete(expected);
    }
}