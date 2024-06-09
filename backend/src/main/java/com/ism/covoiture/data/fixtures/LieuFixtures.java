package com.ism.covoiture.data.fixtures;

import com.ism.covoiture.data.entities.Lieu;
import com.ism.covoiture.data.repositories.LieuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component
@Order(3)
@RequiredArgsConstructor
public class LieuFixtures implements CommandLineRunner {
    private final LieuRepository lieuRepository;

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        List<String> names = new ArrayList<>();
        List<Double> pos = new ArrayList<>();
        names.add("Mermoz, Dakar");
        names.add("Almadies, Dakar");
        names.add("Point E, Dakar");
        names.add("Foire, Dakar");
        names.add("Plateau, Dakar");
        names.add("liberte 6, Dakar");
        pos.add(11.23456);
        pos.add(12.3456);
        pos.add(13.4567);
        pos.add(14.6789);
        pos.add(15.6789);
        for (int i = 0; i < 6; i++) {
            int lat = random.nextInt(4);
            int lon = random.nextInt(4);
            Lieu lieu = new Lieu();
            lieu.setLibelle(names.get(i));
            lieu.setLatitude(pos.get(lat));
            lieu.setLongitude(pos.get(lon));
            lieuRepository.save(lieu);
        }
    }
}
