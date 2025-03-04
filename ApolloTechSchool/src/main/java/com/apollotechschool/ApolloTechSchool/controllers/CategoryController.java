package com.apollotechschool.ApolloTechSchool.controllers;

/* CategoryController
 * Handle HTTP Requests related to the Category Entity
 * */

import com.apollotechschool.ApolloTechSchool.payloads.CategoryPayload;
import com.apollotechschool.ApolloTechSchool.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* CategoryController
 * Handle HTTP Requests related to the Category Entity
 * */

@RestController
@RequestMapping("/api/categories")
public class CategoryController
{
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryPayload>> getAllCategories()
    {
        List<CategoryPayload> categoryPayloadList = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryPayloadList);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryPayload> getCategoryById(@PathVariable("id") Long id)
    {
        CategoryPayload categoryPayload = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryPayload);
    }

}
