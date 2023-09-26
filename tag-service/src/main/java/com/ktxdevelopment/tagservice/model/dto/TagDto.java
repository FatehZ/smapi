package com.ktxdevelopment.siratumustakim.tag.model.dto;

import com.ktxdevelopment.siratumustakim.tag.model.response.TagResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TagDto {

    private String tagId;
    private String description;
    private String title;

    public TagResponse toResponse() {
        return new TagResponse(tagId, description, title);
    }
}
