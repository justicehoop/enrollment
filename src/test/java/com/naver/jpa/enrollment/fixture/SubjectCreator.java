package com.naver.jpa.enrollment.fixture;

import com.naver.jpa.enrollment.code.SubjectType;
import com.naver.jpa.enrollment.domain.Subject;
import com.naver.jpa.enrollment.dto.SubjectRequest;


public class SubjectCreator {

    public static Subject createMandatory(Long id, String name, String description) {
        return create(id, name, description, SubjectType.MANDATORY);
    }

    public static Subject createOptional(Long id, String name, String description) {
        return create(id, name, description, SubjectType.OPTIONAL);
    }

    public static Subject create(Long id, String name, String description, SubjectType subjectType) {
        return Subject.builder()
                .id(id)
                .name(name)
                .description(description)
                .subjectType(subjectType)
                .build();
    }

    public static SubjectRequest createRequest(String name, String description) {
        return SubjectRequest
                .builder()
                .name(name)
                .description(description)
                .subjectType(SubjectType.MANDATORY)
                .build();
    }


}
