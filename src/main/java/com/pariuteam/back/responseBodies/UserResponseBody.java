package com.pariuteam.back.responseBodies;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;
@Data
public class UserResponseBody {
    private String nom;
    private String prenom;
    private String mail;
    private String code_postal;
    private String ville;
    private String telephone;
    @Temporal(TemporalType.DATE)
    private Date date;
}
