package com.membershipapi.api.controller.dto;

import com.membershipapi.api.model.MembershipType;

import java.util.Date;

public class MembershipHistoryDTO {

    private Long id;


    private int profileId;


    private int membershipTypeID;



    private Date startDate;


    private Date endDate;


    private double payment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getMembershipTypeID() {
        return membershipTypeID;
    }

    public void setMembershipTypeID(int membershipTypeID) {
        this.membershipTypeID = membershipTypeID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }
}
