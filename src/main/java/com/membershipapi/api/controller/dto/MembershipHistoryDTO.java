package com.membershipapi.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class MembershipHistoryDTO {

    private UUID id;
    private int profileId;
    private UUID membershipTypeID;
    private Date startDate;
    private Date endDate;
    private double payment;

}
