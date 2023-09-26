package com.ktxdevelopment.siratumustakim.category.model.dto;

import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryFullDto {
    private String categoryId;
    private String title;
    private String description;
    private String image;
    private List<PostLitDto> posts;
}
