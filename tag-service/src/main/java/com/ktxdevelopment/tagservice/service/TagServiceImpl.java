package com.ktxdevelopment.siratumustakim.tag.service;

import com.ktxdevelopment.siratumustakim.exceptions.TagNotFoundException;
import com.ktxdevelopment.siratumustakim.tag.model.dto.TagDto;
import com.ktxdevelopment.siratumustakim.tag.model.entity.Tag;
import com.ktxdevelopment.siratumustakim.tag.model.response.TagResponse;
import com.ktxdevelopment.siratumustakim.tag.repo.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public List<TagResponse> getAllTags() {
        List<TagDto> tags = tagRepository.findAll(Sort.by(Sort.Direction.ASC, "title")).stream().map(Tag::toDtoAz).toList();
        return tags.stream().map(TagDto::toResponse).collect(Collectors.toList());
    }

    @SneakyThrows
    @Override
    public TagResponse getTagByTagId(String tagId) {
        var dto = tagRepository.findTagByTagId(tagId).orElseThrow(TagNotFoundException::new).toDtoAz();
        return dto.toResponse();
    }
}
