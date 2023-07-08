package com.naver.jpa.enrollment.service;

import static org.junit.jupiter.api.Assertions.*;

import com.naver.jpa.enrollment.repository.LectureRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void test() {

    }

}