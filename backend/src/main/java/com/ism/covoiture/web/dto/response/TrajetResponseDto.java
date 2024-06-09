package com.ism.covoiture.web.dto.response;

import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.data.entities.Trajet;
import com.ism.covoiture.security.data.entity.Personne;
import com.ism.covoiture.web.dto.request.UserCreateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TrajetResponseDto {
    private long id;
    private Lieu depart;
    private Lieu destination;
    private Integer prix;
    private LocalDate date;
    private Integer notation;

    public static TrajetResponseDto toDto(Trajet trajet){
        return new TrajetResponseDto(trajet.getId(), trajet.getDepart(),
        trajet.getDestination(), trajet.getPrix(), trajet.getDate(),
                trajet.getNotation());
    }
}
