package com.membershipapi.api.controller;

import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.service.MembershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membershipType")
public class MembershipTypeController {

    private final MembershipTypeService membershipTypeService;

    @Autowired
    public MembershipTypeController(MembershipTypeService membershipTypeService) {
        this.membershipTypeService = membershipTypeService;
    }

    @GetMapping
    public List<MembershipType> getAllMembershipTypes() {
        List<MembershipType> membershipTypeTypes = membershipTypeService.getAllMemberships();
        return membershipTypeTypes;
    }

    @PostMapping
    public List<MembershipType> addMembershipType(@RequestBody MembershipType membershipType) {
        membershipTypeService.createMembership(membershipType);
        return membershipTypeService.getAllMemberships();
    }

    @DeleteMapping("/{id}")
    public void deleteMembership(@PathVariable int id)
    {
        membershipTypeService.deleteMembership(id);
    }
}
