package com.pariuteam.back.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "result")
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "firstFoodId", referencedColumnName = "foodId")
    private Food firstFood;

    @ManyToOne
    @JoinColumn(name = "secondFoodId", referencedColumnName = "foodId")
    private Food secondFood;

    @ManyToOne
    @JoinColumn(name = "thirdFoodId", referencedColumnName = "foodId")
    private Food thirdFood;

    @ManyToOne
    @JoinColumn(name = "fourthFoodId", referencedColumnName = "foodId")
    private Food fourthFood;

    @ManyToOne
    @JoinColumn(name = "fifthFoodId", referencedColumnName = "foodId")
    private Food fifthFood;

    @ManyToOne
    @JoinColumn(name = "sixthFoodId", referencedColumnName = "foodId")
    private Food sixthFood;

    @ManyToOne
    @JoinColumn(name = "seventhFoodId", referencedColumnName = "foodId")
    private Food seventhFood;

    @ManyToOne
    @JoinColumn(name = "eighthFoodId", referencedColumnName = "foodId")
    private Food eighthFood;

    @ManyToOne
    @JoinColumn(name = "ninthFoodId", referencedColumnName = "foodId")
    private Food ninthFood;

    @ManyToOne
    @JoinColumn(name = "tenthFoodId", referencedColumnName = "foodId")
    private Food tenthFood;
}
