package com.bloggingApp.com.bloggApp_api.repositories;

import com.bloggingApp.com.bloggApp_api.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
