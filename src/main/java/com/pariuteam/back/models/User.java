package com.pariuteam.back.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
    private String cityName;
    private String postalCode;
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    private String phoneNumber;


    @ManyToMany
    @JoinTable(name = "favourite_foods",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "food_id")})
    private List<Food> foodList;

}
