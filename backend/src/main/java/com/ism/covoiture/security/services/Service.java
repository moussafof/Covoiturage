package com.ism.covoiture.security.services;

import com.ism.covoiture.security.data.entity.AppRole;
import org.springframework.security.core.userdetails.UserDetails;

import com.ism.covoiture.security.data.entity.Personne;

public interface Service {
    AppRole getRoleById(long id);
    Personne getUserbyName(String name);
    void saveUser(String username,String email, String tel, String password);
    void saveRole(String roleName);
    void addRoleToUser(String username, String roleName);
    UserDetails loadUserByUsername(String username);
    
}
