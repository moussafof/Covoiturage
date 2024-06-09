package com.ism.covoiture.api.restController.impl;

import com.ism.covoiture.api.restController.UserRestController;
import com.ism.covoiture.security.data.entity.Personne;
import com.ism.covoiture.security.services.Service;
import com.ism.covoiture.web.dto.request.UserCreateRequestDto;
import com.ism.covoiture.web.dto.response.RestResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestControllerImpl implements UserRestController {
    private final Service securityService;

    @Override
    public ResponseEntity<?> create(UserCreateRequestDto user) {
        securityService.saveUser(user.getNomComplet(), user.getUsername(), user.getTel(), "passer");
        securityService.addRoleToUser(user.getNomComplet(), "passager");
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
