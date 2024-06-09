package com.ism.covoiture.security.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;

public interface SecurityController {
    @GetMapping("/")
    public String login(@AuthenticationPrincipal UserDetails userDetails);
    
}
