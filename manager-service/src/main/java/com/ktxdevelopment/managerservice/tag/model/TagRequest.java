package com.ktxdevelopment.siratumustakim.manager.tag.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TagRequest {

    private String tagId;
    private String title_az;
    private String title_tr;
    private String description_az;
    private String description_tr;
}
