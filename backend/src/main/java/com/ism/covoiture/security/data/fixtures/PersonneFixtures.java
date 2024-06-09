package com.ism.covoiture.security.data.fixtures;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ism.covoiture.security.data.entity.Personne;
import com.ism.covoiture.security.data.repositories.PersonneRepo;
import com.ism.covoiture.security.data.repositories.RoleRepo;

import lombok.RequiredArgsConstructor;

//@Component
@Order(2)
@RequiredArgsConstructor
public class PersonneFixtures implements CommandLineRunner  {

    private final PersonneRepo personneRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 5; i++) {
            Personne personne= new Personne();
            personne.setNomComplet("user_"+i);
            personne.setMail("user_"+i+"@gmail.com");
            personne.setPassword(passwordEncoder.encode("passer"));
            personne.setTel("77669302"+i);
            personne.getRoles().add(i%2==0?roleRepo.findById((2L)).get():roleRepo.findById((3L)).get());
            personneRepo.save(personne);
        }
    
    }
    
}
