package com.ism.covoiture.web.dto.request;

import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.security.data.entity.Personne;

import java.time.LocalDate;

public class TrajetRequestDto {
    private Lieu depart;
    private Lieu destination;
    private Integer prix;
    private LocalDate date;
}
