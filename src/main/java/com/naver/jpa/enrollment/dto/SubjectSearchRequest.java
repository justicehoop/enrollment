package com.naver.jpa.enrollment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@NoArgsConstructor
public class SubjectSearchRequest {
    private String name;
    private String description;

    public boolean hasName() {
        return StringUtils.hasText(name);
    }

    public boolean hasDescription() {
        return StringUtils.hasText(description);
    }

}
