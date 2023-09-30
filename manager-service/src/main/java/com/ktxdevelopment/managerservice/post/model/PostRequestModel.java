package com.ktxdevelopment.siratumustakim.manager.post.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequestModel {
    String postId;
    String title;
    String subtitle;
    List<String> tagIds;
    String categoryId;
    String content;
    String authorId;
    List<String> references;
    Long viewed;
}