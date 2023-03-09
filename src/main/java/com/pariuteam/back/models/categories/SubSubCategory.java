package com.pariuteam.back.models.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sub_sub_categories")
public class SubSubCategory {
    @Id
    private Long SubSubCategoryId;

    private String SubSubCategoryName;
}
