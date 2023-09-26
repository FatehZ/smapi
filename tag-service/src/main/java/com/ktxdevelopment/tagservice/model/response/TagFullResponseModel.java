package com.ktxdevelopment.siratumustakim.tag.model.response;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagFullResponseModel {
    private String tagId;
    private String title;
    private List<Post> posts;
    private String description;
}
