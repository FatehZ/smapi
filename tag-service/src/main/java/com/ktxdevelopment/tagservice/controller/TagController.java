package com.ktxdevelopment.siratumustakim.tag.controller;


import com.ktxdevelopment.siratumustakim.tag.model.response.TagResponse;
import com.ktxdevelopment.siratumustakim.tag.service.TagService;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1/tags")
@RequiredArgsConstructor
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/get")
    public ResponseEntity<CustomResponseModel<List<TagResponse>>> getAllCategories() {
        return RestResponse.ok(tagService.getAllTags());
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<CustomResponseModel<TagResponse>> getTags(@PathVariable String tagId) {
        return RestResponse.ok(tagService.getTagByTagId(tagId));
    }
}
