package com.ism.covoiture.security.data.entity;

import java.util.List;

import com.ism.covoiture.data.entities.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class AppRole extends AbstractEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    private List<Personne>users;
}
