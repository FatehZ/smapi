package com.ktxdevelopment.siratumustakim.category.model.entity;


import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity(name = "category")
@Table(name = "categories")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {

    @Id
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "title_az")
    private String title_az;

    @Column(name = "title_tr")
    private String title_tr;

    @Column(name = "description_az")
    private String description_az;

    @Column(name = "description_tr")
    private String description_tr;

    @Column(name = "image")
    private String image;

    @Lazy
    @OneToMany(mappedBy = "category")
    private List<Post> posts;
}