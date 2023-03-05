package com.pariuteam.back.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userLastName;
    private String mail;
    private Integer streetNumber;
    private String streetName;
    private String buildingNumber;
    private String flatNumber;
    private String cityName;
    private String postalCode;
}
