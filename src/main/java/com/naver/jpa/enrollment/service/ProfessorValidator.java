package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.repository.DomesticProfessorRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.code.NationalType;
import com.naver.jpa.enrollment.domain.ForeignerProfessor;
import com.naver.jpa.enrollment.domain.Professor;
import com.naver.jpa.enrollment.dto.ProfessorJoinRequest;
import com.naver.jpa.enrollment.repository.ProfessorRepository;

@RequiredArgsConstructor
@Component
public class ProfessorValidator {
    private final ProfessorRepository professorRepository;

    public void validate(ProfessorJoinRequest professorJoinRequest) {
    }

    public abstract class AbstractValidator {

        void validate(ProfessorJoinRequest professorJoinRequest) {

            Professor professor = professorJoinRequest.toProfessor();
            validateValues(professor);

            this.validateInternal(professor);
        }

        protected void validateValues(Professor professor) {
            if (StringUtils.hasText(professor.getUserId())) {
                throw new IllegalArgumentException("userId must not be null");
            }

            if (StringUtils.hasText(professor.getName())) {
                throw new IllegalArgumentException("name must not be null");
            }

            if (StringUtils.hasText(professor.getEmail())) {
                throw new IllegalArgumentException("email must not be null");

            }

            if (StringUtils.hasText(professor.getMobile())) {
                throw new IllegalArgumentException("mobile must not be null");
            }

            if (professor.getGender() == null) {
                throw new IllegalArgumentException("gender must not be null");
            }
        }

        protected abstract void validateInternal(Professor professor);

        public abstract boolean isSupportFor(Professor professor);
    }

    @RequiredArgsConstructor
    @Component
    public class DomesticProfessorAbstractValidator extends AbstractValidator {

        private final DomesticProfessorRepository domesticProfessorRepository;

        @Override
        public void validateInternal(Professor professor) {
            DomesticProfessor domesticProfessor = (DomesticProfessor) professor;
            validateFields(domesticProfessor);
        }

        private void validateDuplicated(DomesticProfessor domesticProfessor) {
        }

        private void validateFields(DomesticProfessor domesticProfessor) {

            if (StringUtils.hasText(domesticProfessor.getIdentificationNumber())) {
                throw new IllegalArgumentException("identificationNumber must not be null");
            }
            if (StringUtils.hasText(domesticProfessor.getMobile())) {
                throw new IllegalArgumentException("mobile must not be null");
            }
        }

        @Override
        public boolean isSupportFor(Professor professor) {
            return professor.getNationalType() == NationalType.DOMESTIC;
        }
    }

    @Component
    public class ForeignerProfessorAbstractValidator extends AbstractValidator {

        @Override
        public void validateInternal(Professor professor) {
            ForeignerProfessor foreignerProfessor = (ForeignerProfessor) professor;
            validateFields(foreignerProfessor);
        }

        private void validateFields(ForeignerProfessor foreignerProfessor) {
            StringUtils.hasText(foreignerProfessor.getPassportNumber());
        }

        @Override
        public boolean isSupportFor(Professor professor) {
            return professor.getNationalType() == NationalType.FOREIGNER;
        }
    }

}
