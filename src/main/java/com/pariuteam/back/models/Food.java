package com.pariuteam.back.models;

import com.pariuteam.back.models.categories.Category;
import com.pariuteam.back.models.categories.SubCategory;
import com.pariuteam.back.models.categories.SubSubCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="foods")
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    private String scientificFoodName;
    private String foodName;
    @ManyToOne
    private Category category;
    @ManyToOne
    private SubCategory subCategory;
    @ManyToOne
    private SubSubCategory subSubCategory;

}
