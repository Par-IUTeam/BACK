package com.pariuteam.back.models.categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sub_sub_categories")
public class SubSubCategory {
    @Id
    private Long SubSubCategoryId;
    private String SubSubCategoryName;
    @ManyToOne
    @JoinColumn(name="sub_category_id")
    private SubCategory subCategory;

}
