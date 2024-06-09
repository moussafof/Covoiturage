package com.ism.covoiture.security.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ism.covoiture.security.data.entity.AppRole;

public interface RoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
