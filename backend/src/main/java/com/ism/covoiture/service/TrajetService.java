package com.ism.covoiture.service;

import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.data.entities.Trajet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrajetService {
    Trajet getTrajetById(long id);
    Page<Trajet> getAllTrajetsByDestination(String destination, Pageable pageable);
    Page<Trajet> getAllTrajetsByDepart(String depart, Pageable pageable);
    Page<Trajet> getAllTrajets(Pageable pageable);
    List<Trajet> getAllTrajetsByDestinationAndDepart(Lieu destination, Lieu depart);
}
