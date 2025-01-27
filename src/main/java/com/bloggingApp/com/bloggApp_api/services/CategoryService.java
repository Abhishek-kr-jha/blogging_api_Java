package com.bloggingApp.com.bloggApp_api.services;

import com.bloggingApp.com.bloggApp_api.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
    public CategoryDto createCategory(CategoryDto categoryDto);

//    update
    public CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);

//    delete
    public void deleteCategory(Integer categoryId);



//    get
    public   CategoryDto getCategory(Integer categoryId);



//    get All
    List<CategoryDto> getCategories();

}


