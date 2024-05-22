package com.membershipapi.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@Setter
@Getter
@Entity
public class MembershipHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int profileId;

    public MembershipHistory() {
    }

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    private String membershipTypeName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;


    private double payment;

}
