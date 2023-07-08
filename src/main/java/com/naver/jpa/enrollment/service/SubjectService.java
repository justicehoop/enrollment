package com.naver.jpa.enrollment.service;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.dto.SubjectSearchRequest;
import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.dto.SubjectRequest;
import com.naver.jpa.enrollment.dto.SubjectResponse;
import com.naver.jpa.enrollment.repository.SubjectRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class SubjectService implements SubjectResolver {
    private final SubjectRepository subjectRepository;

    public SubjectResponse create(SubjectRequest subjectRequest) {
        return SubjectResponse.from(subjectRepository.save(Subject.of(subjectRequest.getName(), subjectRequest.getDescription(), subjectRequest.getCredit(), subjectRequest.getSubjectType())));
    }

    public SubjectResponse edit(Long id, SubjectRequest subjectRequest) {
        Subject savedSubject = findOne(id);
        return SubjectResponse.from(subjectRepository.save(savedSubject.edit(subjectRequest.getName(), subjectRequest.getDescription(), subjectRequest.getCredit(), subjectRequest.getSubjectType())));
    }

    public void delete(Long id) {
        subjectRepository.delete(findOne(id));
    }

    @Transactional(readOnly = true)
    public SubjectResponse getOne(Long id) {
        return SubjectResponse.from(findOne(id));
    }

    @Transactional(readOnly = true)
    public Page<SubjectResponse> getAll(SubjectSearchRequest subjectSearchRequest, Pageable pageable) {
        Page<Subject> page = subjectRepository.findAll(subjectSearchRequest, pageable);
        return new PageImpl<>(page.getContent().stream().map(subject -> SubjectResponse.from(subject)).collect(Collectors.toList()),
                pageable,
                page.getTotalElements()
        );
    }

    @Override
    public Subject findOne(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("subject(%d) does not exist", id)));
    }

    @RequiredArgsConstructor
    @Transactional(readOnly = true)
    @Component
    public static class SubjectValidator {
        private final SubjectRepository subjectRepository;

        public void validateForCreate(SubjectRequest subjectRequest) {
            validateDuplicatedName(subjectRequest, null);
        }

        public void validateForEdit(SubjectRequest subjectRequest, Subject owner) {
            validateDuplicatedName(subjectRequest, owner);
        }

        private void validateDuplicatedName(SubjectRequest subjectRequest, Subject owner) {
            this.subjectRepository.findByName(subjectRequest.getName())
                    .ifPresent(subject -> {
                        if (owner == null) {
                            throw new IllegalArgumentException(String.format("subject(name:%s) already exists", subject));
                        }
                        if (owner != null && !owner.equals(subject)) {
                            throw new IllegalArgumentException(String.format("subject(name:%s) already exists", subject));
                        }
                    });

        }
    }

}
