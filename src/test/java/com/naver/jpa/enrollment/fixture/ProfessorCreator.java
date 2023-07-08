package com.naver.jpa.enrollment.fixture;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.NationalType;
import com.naver.jpa.enrollment.domain.Address;
import com.naver.jpa.enrollment.domain.DomesticProfessor;
import com.naver.jpa.enrollment.dto.AddressDto;
import com.naver.jpa.enrollment.dto.ProfessorEditRequest;
import com.naver.jpa.enrollment.dto.ProfessorJoinRequest;

public class ProfessorCreator {

    public static ProfessorJoinRequest createDomesticJoinRequest(String userId,
                                                                 String name,
                                                                 String email,
                                                                 String mobile,
                                                                 AddressDto address,
                                                                 Gender gender,
                                                                 String identificationNumber) {

        return createProfessorBuilder(userId, name, email, mobile, address, gender)
                .identificationNumber(identificationNumber)
                .nationalType(NationalType.DOMESTIC)
                .build();
    }

    public static ProfessorJoinRequest createForeignerRequest(String userId,
                                                              String name,
                                                              String email,
                                                              String mobile,
                                                              AddressDto address,
                                                              Gender gender,
                                                              String countryCode,
                                                              AddressDto homeAddress) {
        return createProfessorBuilder(userId, name, email, mobile, address, gender)
                .countryCode(countryCode)
                .homeAddress(homeAddress)
                .nationalType(NationalType.FOREIGNER)
                .build();
    }

    private static ProfessorJoinRequest.ProfessorJoinRequestBuilder createProfessorBuilder(String userId, String name, String email, String mobile, AddressDto address, Gender gender) {
        return ProfessorJoinRequest.builder()
                .userId(userId)
                .name(name)
                .email(email)
                .mobile(mobile)
                .address(address)
                .gender(gender);
    }

    public static ProfessorEditRequest createDomesticEditRequest(String name, String email, String mobile, AddressDto address, Gender gender, String identificationNumber) {
        return ProfessorEditRequest.builder()
                .name(name)
                .email(email)
                .mobile(mobile)
                .address(address)
                .gender(gender)
                .identificationNumber(identificationNumber)
                .nationalType(NationalType.DOMESTIC)
                .build();

    }

    public static DomesticProfessor createDomesticProfessor(Long id, String userId,
                                                            String name,
                                                            String email,
                                                            String mobile,
                                                            Address address,
                                                            Gender gender,
                                                            String identificationNumber) {
        return DomesticProfessor.builder()
                .id(id)
                .userId(userId)
                .name(name)
                .email(email)
                .mobile(mobile)
                .address(address)
                .gender(gender)
                .identificationNumber(identificationNumber)
                .build();
    }
}
