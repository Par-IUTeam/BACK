package com.pariuteam.back.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;
    private User user;
    private Food food1;
    private Food food2;
    private Food food3;
    private Food food4;
    private Food food5;
    private Food food6;
    private Food food7;
    private Food food8;
    private Food food9;
    private Food food10;
}
