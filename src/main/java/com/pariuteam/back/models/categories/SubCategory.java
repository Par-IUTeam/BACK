package com.pariuteam.back.models.categories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="sub_categories")
public class SubCategory {
    @Id
    private Long SubCategoryId;
    private String SubCategoryName;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
