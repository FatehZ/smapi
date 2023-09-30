package com.ktxdevelopment.siratumustakim.manager.tag.service;

import com.ktxdevelopment.siratumustakim.manager.tag.model.TagRequest;
import com.ktxdevelopment.siratumustakim.manager.tag.repo.TagManagerRepository;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class TagManagerServiceImpl implements TagManagerService {

    @Autowired
    TagManagerRepository tagManagerRepository;

    @Override
    public void insertTag(TagRequest tag) {
        tagManagerRepository.save(Tag.builder().tagId(tag.getTagId())
                .title_az(tag.getTitle_az())
                .title_tr(tag.getTitle_tr())
                .description_az(tag.getDescription_az())
                .description_tr(tag.getDescription_tr())
                .posts(new ArrayList<>())
                .build()
        );
    }

    @Override
    public void deleteTag(String tagId) {
        tagManagerRepository.deleteTagByTagId(tagId);
    }
}
