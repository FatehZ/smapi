package com.ktxdevelopment.siratumustakim.manager.category.service;

import com.ktxdevelopment.siratumustakim.manager.category.model.CategoryRequest;
import org.springframework.stereotype.Service;


@Service
public interface CategoryManagerService {

    void insertCategory(CategoryRequest category);

    void deleteCategory(String id);
}
