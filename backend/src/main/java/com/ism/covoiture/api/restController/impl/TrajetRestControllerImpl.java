package com.ism.covoiture.api.restController.impl;

import com.ism.covoiture.api.restController.TrajetRestController;
import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.data.entities.Trajet;
import com.ism.covoiture.service.LieuService;
import com.ism.covoiture.service.TrajetService;
import com.ism.covoiture.web.dto.response.RestResponseDto;
import com.ism.covoiture.web.dto.response.TrajetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TrajetRestControllerImpl implements TrajetRestController {
    private final TrajetService trajetService;
    private final LieuService lieuService;

    @Override
    public ResponseEntity<?> findAll(int size, int page) {
        Page<Trajet> trajets = trajetService.getAllTrajets(PageRequest.of(page, size));
        Page<TrajetResponseDto> results = trajets.map(t->TrajetResponseDto.toDto(t));
        Map<Object, Object> map = RestResponseDto.response(
                results.getContent(),
                new int[results.getTotalPages()],
                results.getNumber(),
                results.getTotalElements(),
                results.getTotalPages(),
                HttpStatus.OK
        );
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAllByDepartDestination(String depart, String destination) {
        Lieu departt = lieuService.getLieuByLibelle(depart);
        Lieu destinationn = lieuService.getLieuByLibelle(destination);
        Map<Object, Object> map = RestResponseDto.response(null, HttpStatus.NO_CONTENT);
        if(departt != null && destinationn != null) {
            map = RestResponseDto.response(trajetService.getAllTrajetsByDestinationAndDepart(departt, destinationn), HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
