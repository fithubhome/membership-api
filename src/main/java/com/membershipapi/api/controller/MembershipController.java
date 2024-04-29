package com.membershipapi.api.controller;

import com.membershipapi.api.model.Membership;
import com.membershipapi.api.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/memberships")
public class MembershipController {

    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping("")
    public String getAllMemberships(Model model) {
        List<Membership> memberships = membershipService.getAllMemberships();
        model.addAttribute("memberships", memberships);
        return "memberships";
    }

    @PostMapping("/add")
    public String addMembership(@RequestParam String name) {
        Membership membership = new Membership();
        membership.setName(name);
        membershipService.createMembership(membership);
        return "redirect:/memberships";
    }
}
