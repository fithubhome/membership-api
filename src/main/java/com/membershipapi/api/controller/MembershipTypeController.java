package com.membershipapi.api.controller;

import com.membershipapi.api.exception.EntityAllreadyExistsException;
import com.membershipapi.api.exception.EntityNotFoundException;
import com.membershipapi.api.model.MembershipType;
import com.membershipapi.api.service.MembershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/membershipType")
public class MembershipTypeController {

    private final MembershipTypeService membershipTypeService;

    @Autowired
    public MembershipTypeController(MembershipTypeService membershipTypeService) {
        this.membershipTypeService = membershipTypeService;
    }

    @GetMapping
    public ResponseEntity<List<MembershipType>> getAllMembershipTypes() {
        List<MembershipType> membershipTypeTypes = membershipTypeService.getAllMemberships();
        return ResponseEntity.status(200).body(membershipTypeTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipType> getMembershipType(@PathVariable int id) {
        try {
            MembershipType membershipType = membershipTypeService.getMembershipById(id);
            return ResponseEntity.status(200).body(membershipType);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<MembershipType> createMembership(@RequestBody MembershipType membershipType) {
        MembershipType membershipTypeStatus;
        try {
         membershipTypeStatus =   membershipTypeService.createMembership(membershipType);
        } catch (EntityAllreadyExistsException ex) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(membershipTypeStatus);
    }

    @PutMapping
    public ResponseEntity<MembershipType> updateMembership(@RequestBody MembershipType membershipType) {
        MembershipType mbTypeStatus;
        try {
            mbTypeStatus =membershipTypeService.updateMembership(membershipType.getId(), membershipType);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(404).body(null);
        }

        return ResponseEntity.status(200).body(mbTypeStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMembership(@PathVariable int id) {
        try {
            membershipTypeService.deleteMembership(id);
            return ResponseEntity.ok(null);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(404).body(null);
        }
    }

}
