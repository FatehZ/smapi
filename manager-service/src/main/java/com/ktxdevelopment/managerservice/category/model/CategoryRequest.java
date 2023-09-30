package com.ktxdevelopment.siratumustakim.manager.category.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CategoryRequest {

    private String categoryId;
    private String title_az;
    private String title_tr;
    private String description_az;
    private String description_tr;
    private String imageUrl;
}
