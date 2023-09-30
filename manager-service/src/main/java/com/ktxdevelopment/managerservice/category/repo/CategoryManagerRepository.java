package com.ktxdevelopment.siratumustakim.manager.category.repo;

import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryManagerRepository extends JpaRepository<Category, Integer> {

    void deleteCategoryByCategoryId(String categoryId);
}
