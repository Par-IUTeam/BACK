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
    @Column(name="userName")
    private String userName;
    @Column(name="userLastName")
    private String userLastName;
    @Column(name="mail")
    private String mail;
    @Column(name="streetNumber")
    private Integer streetNumber;
    @Column(name="streetName")
    private String streetName;
    @Column(name="buildingNumber")
    private String buildingNumber;
    @Column(name="flatNumber")
    private String flatNumber;
    @Column(name="cityName")
    private String cityName;
    @Column(name="postalCode")
    private String postalCode;
}
