package com.ism.covoiture.security.data.entity;

import java.util.ArrayList;
import java.util.List;

import com.ism.covoiture.data.entities.AbstractEntity;
import com.ism.covoiture.data.entities.Trajet;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="personne")
@Builder
@DiscriminatorColumn(name="role")
@DiscriminatorValue(value="Personne")
public class Personne extends AbstractEntity {

    private String nomComplet;
    private String tel;
    private String mail;
    @ManyToMany
    private List<Trajet> trajets = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<AppRole> roles = new ArrayList<>();
    private String password;

    
}
