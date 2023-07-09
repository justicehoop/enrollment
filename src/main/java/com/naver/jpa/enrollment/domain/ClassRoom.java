package com.naver.jpa.enrollment.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer fixedNumber;
    @Embedded
    private Location location;

    @AllArgsConstructor(staticName = "of")
    @Getter
    @Embeddable
    public static class Location {
        private String floor;
        private String room;
        private String building;
    }
}
