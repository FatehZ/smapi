package com.ktxdevelopment.siratumustakim.post.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "trending_post")
@Table(name = "trending_post")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrendingPost {

    @Id
    @Column(name = "post_id")
    String postId;

    String title_az;

    String title_tr;

    String subtitle_az;

    String subtitle_tr;
}