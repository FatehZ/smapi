package com.ktxdevelopment.siratumustakim.manager.category.controller;


import com.ktxdevelopment.siratumustakim.manager.category.model.CategoryRequest;
import com.ktxdevelopment.siratumustakim.manager.category.service.CategoryManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/manager/category")
@RequiredArgsConstructor
public class CategoryManagerController {

    @Autowired
    private CategoryManagerService categoryManagerService;

    @PostMapping("/add")
    private ResponseEntity<String> insertNewCategory(@RequestBody CategoryRequest category) {
        categoryManagerService.insertCategory(category);
        return ResponseEntity.ok("Added successfully");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteCategory(@PathVariable String id) {
        categoryManagerService.deleteCategory(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}