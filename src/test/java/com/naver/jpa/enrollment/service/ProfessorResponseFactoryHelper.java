package com.naver.jpa.enrollment.service;

import com.naver.jpa.enrollment.dto.DomesticProfessorResponse;
import com.naver.jpa.enrollment.dto.ForeignerProfessorResponse;
import com.naver.jpa.enrollment.dto.ProfessorResponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class ProfessorResponseFactoryHelper {
    private static final List<ProfessorResponse.AbstractProfessorResponseFactory> professorResponseFactories = Collections.unmodifiableList(Arrays.asList(new DomesticProfessorResponse.DomesticProfessorResponseFactory(),
            new ForeignerProfessorResponse.ForeignerProfessorResponseFactory()));

    public static ProfessorResponseFactoryResolver createResolver() {
        return new ProfessorResponseFactoryResolver(professorResponseFactories);
    }
}
