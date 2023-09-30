package com.ktxdevelopment.siratumustakim.post.model.response;

import com.ktxdevelopment.siratumustakim.auth.user.model.response.UserLitResponse;
import com.ktxdevelopment.siratumustakim.category.model.dto.CategoryDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    String postId;
    String title;
    String subtitle;
    List<TagDto> tags;
    CategoryDto category;
    String content;
    UserLitResponse author;
    Date date;
    List<String> references;
    Long viewed;

}
