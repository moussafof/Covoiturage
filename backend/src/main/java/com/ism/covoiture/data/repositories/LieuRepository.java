package com.ism.covoiture.data.repositories;

import com.ism.covoiture.data.entities.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Long> {
    Lieu findById(long id);
    Lieu findByLibelle(String libelle);
    Lieu findByLatitudeAndLongitudeAndActiveTrue(double latitude, double longitude);
    List<Lieu> findByLibelleContainsAndActiveTrue(String libelle);
}
