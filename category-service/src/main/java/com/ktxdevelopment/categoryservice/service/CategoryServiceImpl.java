package com.ktxdevelopment.siratumustakim.category.service;

import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.category.repo.CategoryRepository;
import com.ktxdevelopment.siratumustakim.exceptions.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByCategoryId(String id) throws CategoryNotFoundException {
        var category = categoryRepository.findCategoryByCategoryId(id);
        if (category.isEmpty()) {throw new CategoryNotFoundException();}
        return category.get();
    }
}
