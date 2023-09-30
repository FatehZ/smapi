package com.ktxdevelopment.siratumustakim.manager.tag.service;

import com.ktxdevelopment.siratumustakim.manager.tag.model.TagRequest;
import org.springframework.stereotype.Service;


@Service
public interface TagManagerService {
    void insertTag(TagRequest tag);

    void deleteTag(String id);
}
