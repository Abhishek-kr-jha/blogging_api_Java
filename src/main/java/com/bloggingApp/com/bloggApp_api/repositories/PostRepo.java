package com.bloggingApp.com.bloggApp_api.repositories;

import com.bloggingApp.com.bloggApp_api.entities.Category;
import com.bloggingApp.com.bloggApp_api.entities.Post;
import com.bloggingApp.com.bloggApp_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findAByUser(User user);
    List<Post> findByCategory(Category category);
    @Query("select p from Post p where p.title like :key")
    List<Post> searchByTitle(@Param("key") String title);





}
