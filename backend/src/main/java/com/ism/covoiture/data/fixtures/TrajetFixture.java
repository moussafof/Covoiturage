package com.ism.covoiture.data.fixtures;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ism.covoiture.data.entities.Trajet;
import com.ism.covoiture.data.repositories.LieuRepository;
import com.ism.covoiture.data.repositories.TrajetRepository;
import com.ism.covoiture.security.data.repositories.PersonneRepo;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

//@Component
@Order(4)
@RequiredArgsConstructor

public class TrajetFixture implements CommandLineRunner   {
    private final TrajetRepository trajetRepository;
    private final LieuRepository lieuRepository;
    private final PersonneRepo personneRepo;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 3; i++) {
            Trajet trajet = new Trajet();
            trajet.setPrix(1000*i+400);
            trajet.setNbrPlace(i*5+1);
            trajet.setCurrentPlace(0);
            trajet.setDepart(lieuRepository.findById(i));
            trajet.setDepart(lieuRepository.findById(i+1));
            trajet.setDate(LocalDate.now());
            trajet.setConducteur(personneRepo.findById(2L).get());
            trajet.setNotation(4);
            trajetRepository.save(trajet);
        }
    }
    
}
