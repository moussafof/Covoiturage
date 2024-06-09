package com.ism.covoiture.service.impl;

import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.data.entities.Trajet;
import com.ism.covoiture.data.repositories.LieuRepository;
import com.ism.covoiture.data.repositories.TrajetRepository;
import com.ism.covoiture.service.TrajetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrajetServiceImpl implements TrajetService {
    private final TrajetRepository trajetRepository;
    private final LieuRepository lieuRepository;

    @Override
    public Trajet getTrajetById(long id) {
        return trajetRepository.findById(id);
    }

    @Override
    public Page<Trajet> getAllTrajetsByDestination(String destination, Pageable pageable) {
        Lieu destinationn = lieuRepository.findByLibelle(destination);
        return trajetRepository.findAllByDestinationAndActiveTrue(destinationn, pageable);
    }

    @Override
    public Page<Trajet> getAllTrajetsByDepart(String depart, Pageable pageable) {
        Lieu destinationn = lieuRepository.findByLibelle(depart);
        return trajetRepository.findAllByDepartAndActiveTrue(destinationn, pageable);
    }

    @Override
    public Page<Trajet> getAllTrajets(Pageable pageable) {
        return trajetRepository.findAll(pageable);
    }

    @Override
    public List<Trajet> getAllTrajetsByDestinationAndDepart(Lieu destination, Lieu depart) {
        return trajetRepository.findAllByDepartAndDestinationAndActiveTrue(depart,
                destination);
    }
}
