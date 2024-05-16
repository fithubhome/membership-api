package com.membershipapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@Setter
@Getter
public class MembershipHistory {

    private int id;

    private int profileId;

    private String membershipTypeName;

    private LocalDate startDate;

    private LocalDate endDate;

    private double payment;

}
