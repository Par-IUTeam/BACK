package com.pariuteam.back.models.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="sub_categories")
public class SubCategory {
    @Id
    private Long SubCategoryId;
    private String SubCategoryName;
}
