package com.ktxdevelopment.siratumustakim.post.service;

import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.post.model.dto.PostLitDto;
import com.ktxdevelopment.siratumustakim.post.model.lang.Language;
import com.ktxdevelopment.siratumustakim.post.model.response.PostLitResponse;
import com.ktxdevelopment.siratumustakim.post.model.response.PostResponse;
import com.ktxdevelopment.siratumustakim.post.repo.az.PostRepositoryAz;
import com.ktxdevelopment.siratumustakim.post.repo.main.BasePostRepository;
import com.ktxdevelopment.siratumustakim.post.repo.tr.PostRepositoryTr;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepositoryAz postRepositoryAz;

    @Autowired
    PostRepositoryTr postRepositoryTr;

    @SneakyThrows
    @Override
    public List<PostLitResponse> getPostsPaginated(int page, int limit, String lang) {
        List<PostLitDto> posts;
        posts = execLang(Language.AZ).getAllPaginated(page, limit).orElseThrow(PostNotFoundException::new);
        return posts.stream().map(PostLitDto::toResponse).collect(Collectors.toList());
    }


    @Override
    public List<PostLitResponse> getTrendingPosts(String lang) throws PostNotFoundException {
        var posts  = execLang(lang).getTrendingPosts().orElseThrow(PostNotFoundException::new);
        return posts.stream().map(PostLitDto::toResponse).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public PostResponse getFullPostById(String postId, String lang) {
        var dto = execLang(lang).findPostFullById(postId).orElseThrow(PostNotFoundException::new);
        return dto.toResponse();
    }

    @SneakyThrows
    @Override
    public PostLitResponse getLitPostById(String postId, String lang) {
        var dto = execLang(lang).findPostLitById(postId).orElseThrow(PostNotFoundException::new);
        return dto.toResponse();
    }


    BasePostRepository execLang(String lang) {
        if (lang.equals(Language.AZ)) return postRepositoryAz;
        else return postRepositoryTr;
    }
}