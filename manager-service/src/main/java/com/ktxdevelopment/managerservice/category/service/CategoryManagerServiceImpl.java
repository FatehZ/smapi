package com.ktxdevelopment.siratumustakim.manager.category.service;

import com.ktxdevelopment.siratumustakim.manager.category.model.CategoryRequest;
import com.ktxdevelopment.siratumustakim.manager.category.repo.CategoryManagerRepository;
import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.util.img.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;


@RequiredArgsConstructor
@Service
public class CategoryManagerServiceImpl implements CategoryManagerService {

    @Autowired
    CategoryManagerRepository categoryManagerRepository;

    @Override
    public void insertCategory(CategoryRequest category) {
        String image;

        try {
            image = ImageUtils.imageToBase64(category.getImageUrl());
        } catch (IOException e) { throw new RuntimeException(e); }

        categoryManagerRepository.save(Category.builder().categoryId(category.getCategoryId())
                        .title_az(category.getTitle_az())
                        .title_tr(category.getTitle_tr())
                        .description_az(category.getDescription_az())
                        .description_tr(category.getDescription_tr())
                        .image(image)
                        .posts(new ArrayList<>())
                        .build());
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryManagerRepository.deleteCategoryByCategoryId(categoryId);
    }
}