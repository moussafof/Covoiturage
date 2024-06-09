package com.ism.covoiture.service.impl;

import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.data.repositories.LieuRepository;
import com.ism.covoiture.service.LieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LieuServiceImpl implements LieuService {
    private final LieuRepository lieuRepository;

    @Override
    public Lieu getLieuById(long id) {
        return lieuRepository.findById(id);
    }

    @Override
    public Lieu getLieuByLibelle(String libelle) {
        return lieuRepository.findByLibelle(libelle);
    }

    @Override
    public Lieu getLieuByPosition(double latitude, double longitude) {
        return lieuRepository.findByLatitudeAndLongitudeAndActiveTrue(latitude, longitude);
    }

    @Override
    public List<Lieu> searchLieuByLibelle(String libelle) {
        return lieuRepository.findByLibelleContainsAndActiveTrue(libelle);
    }
}
