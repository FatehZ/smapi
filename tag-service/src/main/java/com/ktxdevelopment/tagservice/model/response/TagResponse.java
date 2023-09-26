package com.ktxdevelopment.siratumustakim.tag.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagResponse {
    private String tagId;
    private String title;
    private String description;
}
