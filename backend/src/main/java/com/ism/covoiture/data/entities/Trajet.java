package com.ism.covoiture.data.entities;

import com.ism.covoiture.security.data.entity.Personne;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "trajet")
public class Trajet extends AbstractEntity{

    private Integer prix;
    private LocalDate date;
    private Integer nbrPlace;
    private Integer currentPlace;
    private Integer notation;
    
    @ManyToOne
    private Personne conducteur;
    @ManyToOne
    private Lieu depart;
    @ManyToOne
    private Lieu destination;
    @OneToMany
    private List<Lieu> arrets = new ArrayList<>();
}
