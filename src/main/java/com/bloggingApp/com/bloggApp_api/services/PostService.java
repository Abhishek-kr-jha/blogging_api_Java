package com.bloggingApp.com.bloggApp_api.services;

import com.bloggingApp.com.bloggApp_api.entities.Post;
import com.bloggingApp.com.bloggApp_api.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId , Integer categoryId);

//    update
    Post updatePost(PostDto postDto , Integer postId);

//    delete
    Post deletePost(Integer  postId);

//    get all posts

    List<Post> getAllPost();


//    get single post
    Post getPostById(Integer  postId);

//    get all posts by category
    List<PostDto> getPostsByCategory(Integer categoryId);

//     get all post by user
    List<PostDto> getPostsByUser(Integer userId);
}
