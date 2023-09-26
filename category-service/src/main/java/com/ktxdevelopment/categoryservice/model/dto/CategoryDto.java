package com.ktxdevelopment.siratumustakim.category.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
        private String categoryId;
        private String title;
        private String description;
        private String image;
};

