package com.bloggingApp.com.bloggApp_api.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryDto {

    private Integer categoryId;
    @NotBlank
    @Size(min = 4,message = "Min size of category title is 4")
    private String categoryTitle;

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @NotBlank
    @Size(min = 10, message = "min size of cateogry desc is 10")
    private String categoryDescription;
}
