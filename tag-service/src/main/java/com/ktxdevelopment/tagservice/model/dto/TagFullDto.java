package com.ktxdevelopment.siratumustakim.tag.model.dto;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TagFullDto {

    private String id;
    private String description;
    private String title;
    private List<Post> posts;
}