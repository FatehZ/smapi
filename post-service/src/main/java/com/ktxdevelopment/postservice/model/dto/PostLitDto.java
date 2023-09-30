package com.ktxdevelopment.siratumustakim.post.model.dto;


import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PostLitDto {
    String postId;
    String title;
    String subtitle;

    public PostLitResponse toResponse() {
        return new PostLitResponse(postId, title, subtitle);
    }
}