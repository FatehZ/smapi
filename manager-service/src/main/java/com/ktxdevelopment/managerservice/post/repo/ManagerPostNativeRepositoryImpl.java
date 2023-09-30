package com.ktxdevelopment.siratumustakim.manager.post.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ManagerPostNativeRepositoryImpl implements ManagerPostNativeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addCategoryToPost(String postId, String categoryId) {
        try{
            String sql = "UPDATE post p SET category_id = ? WHERE p.post_id = ?";
            jdbcTemplate.update(sql, postId, categoryId);
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void addTagToPost(String postId, String tagId) {
        try{
            String sql = "UPDATE post p SET category_id = ? WHERE p.post_id = ?";
            jdbcTemplate.update(sql);
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
