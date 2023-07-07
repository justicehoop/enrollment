package com.naver.jpa.enrollment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.naver.jpa.enrollment.domain.Address;

@Data
@NoArgsConstructor
@Getter
public class AddressDto {
  private String city;
  private String street;
  private String addressDetail;
  private String zipcode;

  public static AddressDto from(Address address) {
    AddressDto response  = new AddressDto();
    response.city = address.getCity();
    response.street = address.getStreet();
    response.addressDetail = address.getAddressDetail();
    response.zipcode = address.getZipcode();
    return response;
  }

  public Address toAddress() {
    return Address.of(this.getCity(),this.getStreet(),this.getAddressDetail(),this.getZipcode());
  }
}
