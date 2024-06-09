package com.ism.covoiture.security.services.impl;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.ism.covoiture.security.data.entity.AppRole;
import com.ism.covoiture.security.data.entity.Personne;
import com.ism.covoiture.security.data.repositories.PersonneRepo;
import com.ism.covoiture.security.data.repositories.RoleRepo;
import com.ism.covoiture.security.services.Service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceImpl implements Service, UserDetailsService {
    private final PersonneRepo personneRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppRole getRoleById(long id) {
        return roleRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Personne getUserbyName(String name) {
        return personneRepo.findByNomComplet(name);
    }

    @Override
    public void saveRole(String roleName) {
        AppRole role = roleRepo.findByRoleName(roleName);
        if(role != null) throw new EntityNotFoundException("role already exists");
        role = new AppRole(roleName, new ArrayList<>());
        roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Personne user = personneRepo.findByNomComplet(username);
        if(user == null) throw new EntityNotFoundException("user not found");
        AppRole role = roleRepo.findByRoleName(roleName);
        if(role == null) throw new EntityNotFoundException("role not found");
        user.getRoles().add(role);;
        personneRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Personne user = personneRepo.findByNomComplet(username);
        if(user == null) throw new EntityNotFoundException("User not found");
        List<SimpleGrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(appRole -> new SimpleGrantedAuthority(appRole.getRoleName())).toList();
        return new User(username, username, false, false, false, false, authorities);
    }

    @Override
    public void saveUser(String username, String email, String tel, String password) {
        Personne user = personneRepo.findByNomComplet(username);
        if (user!=null) throw new RuntimeException("user already exists");
        user = new Personne(username, tel, email, new ArrayList<>(), new ArrayList<>(), password);
        user.setActive(true);
        personneRepo.save(user);
    }
    
}
