package com.membershipapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MembershipType {

    private int id;

    private String name;

    private double price;

}
