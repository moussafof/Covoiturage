package com.ism.covoiture.security.controller.impl;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import com.ism.covoiture.security.controller.SecurityController;
import com.ism.covoiture.security.data.entity.Personne;
import com.ism.covoiture.security.services.Service;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SecurityControllerImpl implements SecurityController {
    private  final Service securityService;

    @Override
    public String login(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails.getAuthorities().stream().anyMatch(role->role.getAuthority().compareTo("ADMIN")==0)){
            return "redirect:/admin/";
        }

        if (userDetails.getAuthorities().stream().anyMatch(role->role.getAuthority().compareTo("CONDUCTEUR")==0)){
            Personne user =  securityService.getUserbyName(userDetails.getUsername());
            return "redirect:/conducteur/"+user.getId();
        }

        if (userDetails.getAuthorities().stream().anyMatch(role->role.getAuthority().compareTo("PASSAGER")==0)){
            Personne user =  securityService.getUserbyName(userDetails.getUsername());
            return "redirect:/passager/"+user.getId();
        }

        return "redirect:/login";
    }
}