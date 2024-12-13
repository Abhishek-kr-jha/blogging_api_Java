package com.bloggingApp.com.bloggApp_api.repositories;

import com.bloggingApp.com.bloggApp_api.entities.Category;
import com.bloggingApp.com.bloggApp_api.entities.Post;
import com.bloggingApp.com.bloggApp_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findAByUser(User user);
    List<Post> findByCategory(Category category);


}
