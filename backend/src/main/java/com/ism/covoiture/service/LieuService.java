package com.ism.covoiture.service;

import com.ism.covoiture.data.entities.Lieu;

import java.util.List;

public interface LieuService {
    Lieu getLieuById(long id);
    Lieu getLieuByLibelle(String libelle);
    Lieu getLieuByPosition(double latitude, double longitude);
    List<Lieu> searchLieuByLibelle(String libelle);
}
