package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.domain.DomesticProfessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.naver.jpa.enrollment.exception.ResourceNotFoundException;
import com.naver.jpa.enrollment.domain.ForeignerProfessor;
import com.naver.jpa.enrollment.domain.Professor;
import com.naver.jpa.enrollment.dto.ProfessorEditRequest;
import com.naver.jpa.enrollment.dto.ProfessorJoinRequest;
import com.naver.jpa.enrollment.dto.ProfessorResponse;
import com.naver.jpa.enrollment.repository.ProfessorRepository;

@RequiredArgsConstructor
@Transactional
@Service
public class ProfessorService implements ProfessorResolver {
    private final ProfessorRepository professorRepository;
    private final ProfessorResponseFactoryResolver professorResponseFactoryResolver;
    private final ProfessorValidator professorValidator;

    public ProfessorResponse join(ProfessorJoinRequest professorJoinRequest) {
        professorValidator.validate(professorJoinRequest);

        Professor professor = professorJoinRequest.toProfessor();
        return convertToResponse(professorRepository.save(professor));
    }

    public ProfessorResponse edit(Long id, ProfessorEditRequest professorEditRequest) {
        Professor savedProfessor = findProfessor(id);

        if (savedProfessor instanceof ForeignerProfessor) {
            ((ForeignerProfessor) savedProfessor).edit(professorEditRequest.getEmail(), professorEditRequest.getMobile(), professorEditRequest.getAddress().toAddress(), professorEditRequest.getGender(), professorEditRequest.getPassportNumber(), professorEditRequest.getHomeAddress().toAddress());
        }
        if (savedProfessor instanceof DomesticProfessor) {
            ((DomesticProfessor) savedProfessor).edit(professorEditRequest.getEmail(), professorEditRequest.getMobile(), professorEditRequest.getAddress().toAddress(), professorEditRequest.getGender(), professorEditRequest.getIdentificationNumber());
        }
        return convertToResponse(professorRepository.save(savedProfessor));
    }

    @Transactional(readOnly = true)
    public ProfessorResponse getOne(Long id) {
        Professor professor = findProfessor(id);
        return convertToResponse(professor);
    }

    private ProfessorResponse convertToResponse(Professor professor) {
        return professorResponseFactoryResolver.resolve(professor)
                .assignProfessor(professor);
    }


    @Override
    public Professor findProfessor(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Professor does not exist(id:%s)", id)));
    }
}
