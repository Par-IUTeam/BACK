package com.pariuteam.back.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="foods")
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

}
