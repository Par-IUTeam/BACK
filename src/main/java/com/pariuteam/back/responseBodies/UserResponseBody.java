package com.pariuteam.back.responseBodies;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserResponseBody {
    private String nom;
    private String prenom;
    private String mail;
    private String code_postal;
    private String ville;
    private String telephone;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
}
