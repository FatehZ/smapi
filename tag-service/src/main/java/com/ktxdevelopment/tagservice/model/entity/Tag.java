package com.ktxdevelopment.siratumustakim.tag.model.entity;

import com.ktxdevelopment.siratumustakim.post.model.entity.Post;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagFullDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity(name ="tag")
@Table(name = "tags")
//@Entity(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {

    @Id
    @Column(name = "tag_id")
    private String tagId;

    @Column(name = "title_az")
    private String title_az;


    @Column(name = "title_tr")
    private String title_tr;

    @Lazy
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;


    @Column(name = "description_az")
    private String description_az;

    @Column(name = "description_tr")
    private String description_tr;

    TagFullDto toDtoFullAz() {
        return new TagFullDto(tagId, title_az, description_az, posts);
    }

    public TagDto toDtoAz() {
        return new TagDto(tagId, title_az, description_az);
    }

    public TagDto toDtoTr() {
        return new TagDto(tagId, title_tr, description_tr);
    }
}