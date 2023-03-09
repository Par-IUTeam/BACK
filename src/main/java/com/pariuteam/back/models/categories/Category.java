package com.pariuteam.back.models.categories;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="categories")
public class Category {

    @Id
    private Long categoryId;
    private String categoryName;
}
