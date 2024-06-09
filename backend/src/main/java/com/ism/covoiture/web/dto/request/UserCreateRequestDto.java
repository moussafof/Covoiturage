package com.ism.covoiture.web.dto.request;

import com.ism.covoiture.security.data.entity.Personne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class UserCreateRequestDto {
    private long id;
    private String username;
    private String nomComplet;
    private String tel;

    public static UserCreateRequestDto toDto(Personne personne){
        return new UserCreateRequestDto(personne.getId(), personne.getMail(),
                personne.getNomComplet(),
                personne.getTel());
    }
}
