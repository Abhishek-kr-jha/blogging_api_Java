package com.bloggingApp.com.bloggApp_api.services;

import com.bloggingApp.com.bloggApp_api.payloads.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDto createComment(CommentDto commentDto , Integer postId);

    void deleteComment(Integer commentId);
}
