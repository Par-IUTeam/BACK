package com.pariuteam.back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

@Entity
@Controller
@Table(name="favourite_foods")
@IdClass(FavouriteFoodId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteFood {
    @Id
    @ManyToOne
    @JoinColumn(name="food_id")
    private Food food;

    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}