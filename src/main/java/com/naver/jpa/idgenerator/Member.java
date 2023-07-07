package com.naver.jpa.idgenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
  name = "MEMBER_SEQ_GENERATOR",
  sequenceName = "MEMBER_SEQUENCE",
  initialValue = 1,
  allocationSize = 50
)
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE,
    generator = "MEMBER_SEQ_GENERATOR")
  private Long id;
}
