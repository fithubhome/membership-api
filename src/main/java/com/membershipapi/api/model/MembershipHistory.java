package com.membershipapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class MembershipHistory {

    private int id;

    private int profileId;

    private int membershipType;

    private Date startDate;

    private Date endDate;

    private int payment;

}
