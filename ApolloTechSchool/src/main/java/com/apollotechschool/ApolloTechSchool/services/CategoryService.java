package com.apollotechschool.ApolloTechSchool.services;

/* CategoryService
 * Contract to establish the methods of the Category Service Implementation
 * What the service does, what it returns, and the expected inputs are all managed from here
 * */

import com.apollotechschool.ApolloTechSchool.payloads.CategoryPayload;

import java.util.List;

public interface CategoryService
{
    List<CategoryPayload> getAllCategories();
    CategoryPayload getCategoryById(Long id);
}
