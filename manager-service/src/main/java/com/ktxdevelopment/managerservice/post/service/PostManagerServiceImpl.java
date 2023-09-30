package com.ktxdevelopment.siratumustakim.manager.post.service;

import com.google.gson.Gson;
import com.ktxdevelopment.siratumustakim.auth.user.repo.UserRepository;
import com.ktxdevelopment.siratumustakim.category.repo.CategoryRepository;
import com.ktxdevelopment.siratumustakim.exceptions.PostNotFoundException;
import com.ktxdevelopment.siratumustakim.manager.post.model.SetTrendingPostsRequest;
import com.ktxdevelopment.siratumustakim.manager.post.repo.ManagerPostNativeRepository;
import com.ktxdevelopment.siratumustakim.manager.post.repo.ManagerPostRepository;
import com.ktxdevelopment.siratumustakim.manager.post.repo.TrendingPostRepository;
import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.post.model.entity.TrendingPost;
import com.ktxdevelopment.siratumustakim.post.model.request.PostRequestModel;
import com.ktxdevelopment.siratumustakim.post.repo.az.PostRepositoryAz;
import com.ktxdevelopment.siratumustakim.post.repo.tr.PostRepositoryTr;
import com.ktxdevelopment.siratumustakim.tag.repo.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@RequiredArgsConstructor
@Service
public class PostManagerServiceImpl implements PostManagerService {

    @Autowired ManagerPostRepository managerPostJPARepository;
    @Autowired ManagerPostNativeRepository managerPostNativeRepository;

    @Autowired TrendingPostRepository trendingPostRepository;
    @Autowired TagRepository tagRepository;
    @Autowired CategoryRepository categoryRepository;
    @Autowired PostRepositoryAz postRepositoryAz;
    @Autowired PostRepositoryTr postRepositoryTr;
    @Autowired UserRepository userRepository;

    @SneakyThrows
    @Override
    public void setTrendingPosts(SetTrendingPostsRequest setTrendingPostsRequest) {
        trendingPostRepository.deleteAll();
        for (String id: setTrendingPostsRequest.trends()) {
            var p = managerPostJPARepository.findPostByPostId(id).orElseThrow(PostNotFoundException::new);
            trendingPostRepository.save(new TrendingPost(p.getPostId(), p.getTitle_az(), p.getTitle_tr(), p.getSubtitle_az(), p.getSubtitle_tr()));
        }
    }

    @Override
    public void insertNewPost(PostRequestModel p) {
        var c = categoryRepository.findCategoryByCategoryId(p.getCategoryId()).orElseThrow();
        var tags = p.getTags().stream().map(id -> tagRepository.findTagByTagId(id).orElseThrow()).toList();
        var author = userRepository.findByUserId(p.getAuthorId()).orElseThrow();
        Gson gson = new Gson();
        String ref_az = gson.toJson(p.getReferences_az());
        String ref_tr = gson.toJson(p.getReferences_tr());

        managerPostJPARepository.save(new Post(p.getPostId(), p.getTitle_az(), p.getTitle_tr(), p.getSubtitle_az(), p.getSubtitle_tr(), tags, c, p.getContent_az(), p.getContent_tr(), author, new Date(), ref_az, ref_tr, 0L));
    }

    @SneakyThrows
    @Override
    public void addCategoryToPost(String postId, String categoryId) {
        managerPostNativeRepository.addCategoryToPost(postId, categoryId);
    }

    @Override
    public void addTagToPost(String postId, String tagId) {
        managerPostNativeRepository.addTagToPost(postId, tagId);
    }
}
