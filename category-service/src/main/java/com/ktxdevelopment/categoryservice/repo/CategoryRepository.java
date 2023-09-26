package com.ktxdevelopment.siratumustakim.category.repo;

import com.ktxdevelopment.siratumustakim.category.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String>, JpaRepository<Category, String> {

    Optional<Category> findCategoryByCategoryId(String categoryId);
}
