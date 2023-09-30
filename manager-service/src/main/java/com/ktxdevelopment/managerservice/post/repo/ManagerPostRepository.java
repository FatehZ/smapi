package com.ktxdevelopment.siratumustakim.manager.post.repo;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerPostRepository extends JpaRepository<Post, String> {

    Optional<Post> findPostByPostId(String postId);
    
}
