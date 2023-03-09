package com.pariuteam.back.models.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
