package com.bloggingApp.com.bloggApp_api.repositories;

import com.bloggingApp.com.bloggApp_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


}
