package com.naver.jpa.enrollment.service;

import java.util.stream.Collectors;

import com.naver.jpa.enrollment.domain.Professor;
import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.dto.LectureRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.dto.LectureResponse;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.domain.Lecture;
import com.naver.jpa.enrollment.dto.LectureSearchRequest;
import com.naver.jpa.enrollment.repository.LectureRepository;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class LectureService implements LectureResolver {

    private final LectureRepository lectureRepository;
    private final SubjectResolver subjectResolver;
    private final ProfessorResolver professorResolver;

    public LectureResponse create(LectureRequest lectureRequest) {
        Professor professor = professorResolver.findProfessor(lectureRequest.getProfessorId());
        Subject subject = subjectResolver.findOne(lectureRequest.getSubjectId());
        Lecture lecture = Lecture.builder()
                .lectureName(lectureRequest.getLectureName())
                .lectureDays(lectureRequest.getLectureDays())
                .lectureHourOfDay(lectureRequest.getLectureHourOfDay())
                .fixedNumber(lectureRequest.getFixedNumber())
                .professor(professor)
                .subject(subject)
                .build();

        return LectureResponse.from(lectureRepository.save(lecture));
    }

    public LectureResponse edit(Long id, LectureRequest lectureRequest) {
        Lecture savedLecture = this.findOne(id);
        Professor professor = professorResolver.findProfessor(lectureRequest.getProfessorId());
        Subject subject = subjectResolver.findOne(lectureRequest.getSubjectId());
        return LectureResponse.from(
                lectureRepository.save(savedLecture.edit(lectureRequest.getLectureName(), lectureRequest.getLectureDays(),
                        lectureRequest.getLectureHourOfDay(), lectureRequest.getFixedNumber(),
                        professor, subject))
        );
    }


    @Transactional(readOnly = true)
    public Page<LectureResponse> getAll(LectureSearchRequest lectureSearchRequest, Pageable pageable) {
        Page<Lecture> page = lectureRepository.findAll(lectureSearchRequest, pageable);

        return new PageImpl<>(page.getContent()
                .stream()
                .map(lecture -> LectureResponse.from(lecture))
                .collect(Collectors.toList()), pageable, page.getTotalElements());
    }

    @Transactional(readOnly = true)
    public LectureResponse getOne(Long id) {
        return LectureResponse.from(findOne(id));
    }

    @Override
    public Lecture findOne(Long id) {
        return lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("lecture(id:%d) does not exist", id)));
    }

    @Service
    @RequiredArgsConstructor
    public static class LectureValidator {

        private final LectureRepository lectureRepository;

        public void validate(LectureRequest lectureRequest) {

        }

    }
}
