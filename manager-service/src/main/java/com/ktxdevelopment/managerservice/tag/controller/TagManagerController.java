package com.ktxdevelopment.siratumustakim.manager.tag.controller;


import com.ktxdevelopment.siratumustakim.manager.tag.model.TagRequest;
import com.ktxdevelopment.siratumustakim.manager.tag.service.TagManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/manager/tags")
@RequiredArgsConstructor
public class TagManagerController {

    @Autowired
    private TagManagerService tagManagerService;

    @PostMapping("/add")
    private ResponseEntity<String> insertNewTag(@RequestBody TagRequest tag) {
        tagManagerService.insertTag(tag);
        return ResponseEntity.ok("Added successfully");
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteTag(@PathVariable String id) {
        tagManagerService.deleteTag(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
