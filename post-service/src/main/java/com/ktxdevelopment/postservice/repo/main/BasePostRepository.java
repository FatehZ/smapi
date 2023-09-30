package com.ktxdevelopment.siratumustakim.post.repo.main;

import com.ktxdevelopment.siratumustakim.post.model.dto.PostDto;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BasePostRepository {

    Optional<PostLitDto> findPostLitById(@Param("postId") String postId);

    Optional<PostDto> findPostFullById(@Param("postId") String postId);

    Optional<List<PostLitDto>> getAllPaginated(int page, int limit);

    Optional<List<PostLitDto>> getTrendingPosts();
}
