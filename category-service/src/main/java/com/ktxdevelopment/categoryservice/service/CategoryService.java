package com.ktxdevelopment.siratumustakim.category.service;

import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import com.ktxdevelopment.siratumustakim.exceptions.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryByCategoryId(String categoryId) throws CategoryNotFoundException;
}
