package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.post.model.response.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {


    List<PostLitResponse> getPostsPaginated(int page, int limit, String lang);

    List<PostLitResponse> getTrendingPosts(String lang) throws PostNotFoundException;

    PostResponse getFullPostById(String postId, String lang);

    PostLitResponse getLitPostById(String postId, String lang);
}
