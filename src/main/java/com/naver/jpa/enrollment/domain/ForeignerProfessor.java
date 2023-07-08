package com.naver.jpa.enrollment.domain;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import com.naver.jpa.enrollment.code.Gender;
import com.naver.jpa.enrollment.code.NationalType;

@NoArgsConstructor
@Setter(AccessLevel.PACKAGE)
@Getter
@Entity
@DiscriminatorValue(NationalType.Values.FOREIGNER)
public class ForeignerProfessor extends Professor {
    @Column(length = 30)
    private String passportNumber;
    @Column(length = 5)
    private String countryCode;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "addressDetail", column = @Column(name = "HOME_ADDRESS_DETAIL")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "HOME_ZIP")),
    })
    private Address homeAddress;

    @Builder
    public ForeignerProfessor(Long id,
                              String userId,
                              String email,
                              String name,
                              String mobile,
                              Address address,
                              Gender gender,
                              Set<Lecture> lectures,
                              String passportNumber,
                              String countryCode,
                              Address homeAddress) {
        super(id, userId, email, name, mobile, address, gender, lectures);
        this.passportNumber = passportNumber;
        this.countryCode = countryCode;
        this.homeAddress = homeAddress;
    }

    public Professor edit(String email, String mobile, Address address, Gender gender,
                             String passportNumber,
                             Address homeAddress
    ) {
        super.edit(email, mobile, address, gender);
        this.passportNumber = passportNumber;
        this.homeAddress = homeAddress;
        return this;
    }

    @Override
    public NationalType getNationalType() {
        return NationalType.FOREIGNER;
    }
}
