package com.ism.covoiture.api.restController;

import com.ism.covoiture.web.dto.request.TrajetRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/trajets")
public interface TrajetRestController {
    @GetMapping("")
    ResponseEntity<?> findAll(@RequestParam(defaultValue = "5") int size,
                              @RequestParam(defaultValue = "0") int page);

    @GetMapping("/search")
    ResponseEntity<?> findAllByDepartDestination(@RequestParam() String depart, @RequestParam() String destination);

    @PostMapping("/save")
    ResponseEntity<?> saveTrajet(TrajetRequestDto trajet);
}
