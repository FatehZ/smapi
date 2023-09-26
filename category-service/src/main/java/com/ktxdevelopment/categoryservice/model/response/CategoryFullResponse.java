package com.ktxdevelopment.siratumustakim.category.model.response;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;

import java.util.List;


public class CategoryFullResponse {
    private String categoryId;
    private String title;
    private String description;
    private String image;
    private List<Post> posts;
}
