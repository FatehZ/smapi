package com.ktxdevelopment.siratumustakim.post.controller;


import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.post.service.PostService;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/get")
    public ResponseEntity<CustomResponseModel<List<PostLitResponse>>> getAllPostsPaginated(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "30") int limit,
            @RequestParam(name = "lang", defaultValue = "az") String lang) {
        return RestResponse.ok(postService.getPostsPaginated(page, limit, lang));
    }

    @GetMapping("/trending")
    public ResponseEntity<CustomResponseModel<List<PostLitResponse>>> getTrendingPosts(
            @RequestParam(name = "lang", defaultValue = "az") String lang) throws PostNotFoundException {
        return RestResponse.ok(postService.getTrendingPosts(lang));
    }


    @GetMapping("/get/{postId}")
    public ResponseEntity<CustomResponseModel<PostResponse>> getPostById(
            @PathVariable String postId,
            @RequestParam(name = "lang", defaultValue = "az") String lang) {
        return RestResponse.ok(postService.getFullPostById(postId ,lang));
    }


    @GetMapping("/get/{postId}/lit")
    public ResponseEntity<CustomResponseModel<PostLitResponse>> getLitPostById(
            @PathVariable String postId,
            @RequestParam(name = "lang", defaultValue = "az") String lang) {
        return RestResponse.ok(postService.getLitPostById(postId, lang));
    }
}
