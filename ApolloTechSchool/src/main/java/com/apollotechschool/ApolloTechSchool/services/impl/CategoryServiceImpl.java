package com.apollotechschool.ApolloTechSchool.services.impl;

/* CategoryServiceImpl
 * Category Service Implementation
 * Establish Business Logic on DB interactions related to the Category Entity
 * */

import com.apollotechschool.ApolloTechSchool.entities.Category;
import com.apollotechschool.ApolloTechSchool.exceptions.EntityNotFoundException;
import com.apollotechschool.ApolloTechSchool.payloads.CategoryPayload;
import com.apollotechschool.ApolloTechSchool.repositories.CategoryRepository;
import com.apollotechschool.ApolloTechSchool.services.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService
{
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryPayload> getAllCategories()
    {
        // It sorts categories by name and not by ID, fix later
        List<Category> categories = categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<CategoryPayload> categoryPayloadList = new ArrayList<>();

        for (Category category : categories)
        {
            categoryPayloadList.add(new CategoryPayload(
                    category.getId(),
                    category.getName()
            ));
        }

        return categoryPayloadList;
    }

    @Override
    public CategoryPayload getCategoryById(Long id)
    {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Category of id " + id + " could not be found")
        );

        return new CategoryPayload(
                category.getId(),
                category.getName()
        );
    }
}
