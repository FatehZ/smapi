package com.ktxdevelopment.siratumustakim.manager.post.repo;

public interface ManagerPostNativeRepository {

    void addCategoryToPost(String postId, String categoryId);

    void addTagToPost(String postId, String tagId);

}
