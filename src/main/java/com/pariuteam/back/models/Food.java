package com.pariuteam.back.models;

import com.pariuteam.back.models.categories.Category;
import com.pariuteam.back.models.categories.SubCategory;
import com.pariuteam.back.models.categories.SubSubCategory;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="food")
@Entity
public class Food {
    @Id
    private Long foodId;

    private String scientificFoodName;
    private String foodName;
    @JoinColumn(name="category_id")
    @ManyToOne
    private Category category;
    @JoinColumn(name="sub_category_id")
    @ManyToOne
    private SubCategory subCategory;
    @JoinColumn(name="sub_sub_category_id")
    @ManyToOne
    private SubSubCategory subSubCategory;

}