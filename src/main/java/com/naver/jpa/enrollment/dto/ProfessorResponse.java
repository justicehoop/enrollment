package com.naver.jpa.enrollment.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.domain.Professor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ProfessorResponse {
  protected Long id;
  protected String userId;
  protected String email;
  protected String mobile;
  protected AddressDto address;
  protected Gender gender;

  public static ProfessorResponse from(Professor professor) {
    return ProfessorResponse.builder()
      .id(professor.getId())
      .userId(professor.getUserId())
      .email(professor.getEmail())
      .mobile(professor.getMobile())
      .address(AddressDto.from(professor.getAddress()))
      .gender(professor.getGender())
      .build();
  }

  @Component
  public static abstract class AbstractProfessorResponseFactory {

    protected ProfessorResponse assignProfessor(Professor professor, ProfessorResponse response) {
      response.id = professor.getId();
      response.userId = professor.getUserId();
      response.email = professor.getEmail();
      response.mobile = professor.getMobile();
      response.address = AddressDto.from(professor.getAddress());
      return response;
    }

    public ProfessorResponse assignProfessor(Professor professor) {
      ProfessorResponse response = this.createInternal(professor);
      return assignProfessor(professor, response);
    }

    protected abstract ProfessorResponse createInternal(Professor professor);

    public abstract boolean isSupportFor(Professor professor);
  }

}
