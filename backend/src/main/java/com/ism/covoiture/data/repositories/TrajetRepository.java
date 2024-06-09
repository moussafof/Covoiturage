package com.ism.covoiture.data.repositories;

import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.data.entities.Trajet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, Long> {
    Trajet findById(long id);
    Trajet findByDestination(Lieu destination);
    Page<Trajet> findAllByDestinationAndActiveTrue(Lieu destination, Pageable pageable);
    Page<Trajet> findAllByDepartAndActiveTrue(Lieu depart, Pageable pageable);
    List<Trajet> findAllByDepartAndDestinationAndActiveTrue(Lieu depart, Lieu destination);
    Page<Trajet> findAll(Pageable pageable);
}
