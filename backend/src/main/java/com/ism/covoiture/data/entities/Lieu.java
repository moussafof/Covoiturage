package com.ism.covoiture.data.entities;

import jakarta.persistence.*;
import lombok.*;

// import java.util.ArrayList;
// import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "lieu")
public class Lieu extends AbstractEntity{
    @Column(unique = true, length = 50)
    private String libelle;
    private Double latitude;
    private Double longitude;
}
