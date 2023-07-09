package com.naver.jpa.enrollment.service;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.domain.Enrollment;
import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.domain.Student;
import com.naver.jpa.enrollment.dto.EnrollmentResponse;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.repository.EnrollmentRepository;
import com.naver.jpa.enrollment.repository.LectureRepository;
import com.naver.jpa.enrollment.repository.StudentRepository;
import com.naver.jpa.enrollment.repository.custom.EnrollmentSearchRequest;

@Transactional
@RequiredArgsConstructor
@Service
public class EnrollmentService {

    private final StudentResolver studentResolver;
    private final LectureResolver lectureResolver;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional(readOnly = true)
    public Page<EnrollmentResponse> getAll(Long studentId, EnrollmentSearchRequest enrollmentSearchRequest, Pageable pageable) {
        Page<Enrollment> page = enrollmentRepository.findAll(studentId, enrollmentSearchRequest, pageable);
        return new PageImpl<>(page.getContent()
                .stream()
                .map(enrollment -> EnrollmentResponse.from(enrollment))
                .collect(Collectors.toList()), pageable, page.getTotalElements());
    }

    public EnrollmentResponse register(Long studentId, Long lectureId) {
        Student student = studentResolver.findOne(studentId);
        Lecture lecture = lectureResolver.findOne(lectureId);
        checkAvailableToEnrollment(lecture);
        return EnrollmentResponse.from(enrollmentRepository.save(Enrollment.of(student, lecture)));
    }

    private void checkAvailableToEnrollment(Lecture lecture) {
        long enrollmentCount = enrollmentRepository.countByLecture(lecture);
        if (lecture.isExceed(enrollmentCount)) {
            throw new IllegalStateException("The count of allowed enrollment is already exceeded!");
        }
    }

    public void cancel(Long studentId, Long lectureId) {
        Student student = studentResolver.findOne(studentId);
        Lecture lecture = lectureResolver.findOne(lectureId);
        Enrollment enrollment = this.findOne(student, lecture);
        enrollmentRepository.delete(enrollment);
    }


    private Enrollment findOne(Student student, Lecture lecture) {
        return enrollmentRepository.findById(Enrollment.EnrollmentKey.of(student, lecture))
                .orElseThrow(() -> new ResourceNotFoundException(String.format("enrollment for (student:%id, lecture:%d) does not exist", student.getId(), lecture.getId())));
    }
}
