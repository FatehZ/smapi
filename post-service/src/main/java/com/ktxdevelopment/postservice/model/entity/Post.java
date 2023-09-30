package com.ktxdevelopment.siratumustakim.post.model.entity;

import com.ktxdevelopment.siratumustakim.auth.user.model.entity.User;
import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post")
@Table(name = "posts")
public class Post {

    @Id
    @Column(name = "post_id")
    String postId;

    @Column(name = "title_az")
    String title_az;

    @Column(name = "title_tr")
    String title_tr;

    @Column(name = "subtitle_az")
    String subtitle_az;

    @Column(name = "subtitle_tr")
    String subtitle_tr;

    @ManyToMany
    @JoinTable(name = "tag_post", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Column(name = "content_az", nullable = false, columnDefinition = "TEXT")
    String content_az;

    @Column(name = "content_tr", nullable = false, columnDefinition = "TEXT")
    String content_tr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User author;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "reference_az", columnDefinition = "TEXT")
    String reference_az;

    @Column(name = "reference_tr", columnDefinition = "TEXT")
    String reference_tr;

    @Column(name = "viewed")
    Long viewed;
}