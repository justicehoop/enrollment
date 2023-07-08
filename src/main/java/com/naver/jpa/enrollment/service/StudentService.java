package com.naver.jpa.enrollment.service;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.domain.Locker;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.domain.Student;
import com.naver.jpa.enrollment.dto.StudentCreateRequest;
import com.naver.jpa.enrollment.dto.StudentEditRequest;
import com.naver.jpa.enrollment.dto.StudentResponse;
import com.naver.jpa.enrollment.dto.StudentSearchRequest;
import com.naver.jpa.enrollment.repository.LockerRepository;
import com.naver.jpa.enrollment.repository.StudentRepository;

@AllArgsConstructor
@Transactional
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final LockerRepository lockerRepository;
    private final StudentValidator studentValidator;

    public StudentResponse create(StudentCreateRequest studentCreateRequest) {
        studentValidator.validateWhenCreate(studentCreateRequest);
        Student student = Student.createBuilder()
                .name(studentCreateRequest.getName())
                .email(studentCreateRequest.getEmail())
                .password(studentCreateRequest.getPassword1())
                .dayOfBirth(studentCreateRequest.getDayOfBirth())
                .build();
        return StudentResponse.from(studentRepository.save(student));
    }

    public StudentResponse edit(Long id, StudentEditRequest studentEditRequest) {
        Student savedStudent = findOne(id);
        studentValidator.validateWhenEdit(studentEditRequest, savedStudent);
        savedStudent = studentRepository.save(savedStudent.edit(studentEditRequest.getName(), studentEditRequest.getEmail(), studentEditRequest.getPassword1(), studentEditRequest.getDayOfBirth()));
        return StudentResponse.from(savedStudent);
    }

    public StudentResponse assignLocker(Long id, Long lockerId) {
        Student savedStudent = findOne(id);
        Locker locker = findLocker(lockerId);

        return StudentResponse.from(studentRepository.save(savedStudent.assignLocker(locker)));
    }

    @Transactional(readOnly = true)
    public StudentResponse getOne(Long id) {
        return StudentResponse.from(findOne(id));
    }

    @Transactional(readOnly = true)
    public Page<StudentResponse> findAll(StudentSearchRequest studentSearchRequest, Pageable pageable) {
        Page<Student> page = studentRepository.findAll(studentSearchRequest, pageable);
        return new PageImpl<>(page.getContent().stream()
                .map(student -> StudentResponse.from(student))
                .collect(Collectors.toList()), pageable, page.getTotalElements());
    }

    private Student findOne(Long id) {
        return studentRepository.findOne(id)
                .orElseThrow(() -> new ResourceNotFoundException(""));
    }

    private Locker findLocker(Long id) {
        return lockerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("locker(id:%d) does not exist", id)));
    }

    @Service
    @RequiredArgsConstructor
    public static class StudentValidator {

        private final StudentRepository studentRepository;

        public void validateWhenCreate(StudentCreateRequest studentCreateRequest) {
            checkDuplicatedUserId(studentCreateRequest.getUserId());
            checkDuplicatedEmail(studentCreateRequest.getEmail(), null);
        }

        public void validateWhenEdit(StudentEditRequest studentEditRequest, Student owner) {
            checkDuplicatedEmail(studentEditRequest.getEmail(), owner);
        }

        private void checkDuplicatedUserId(String userId) {
            Student student = studentRepository.findByUserId(userId);
            if (student != null) {
                throw new IllegalArgumentException("email must not be duplicated!");
            }
        }

        private void checkDuplicatedEmail(String email, @Nullable Student owner) {
            Student byEmail = studentRepository.findByEmail(email);

            if (owner == null && byEmail != null) {
                throw new IllegalArgumentException("email must not be duplicated!");
            }

            if (byEmail != null && !byEmail.isSameOf(owner)) {
                throw new IllegalArgumentException("email must not be duplicated!");
            }
        }

    }

}
