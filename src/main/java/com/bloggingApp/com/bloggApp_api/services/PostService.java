package com.bloggingApp.com.bloggApp_api.services;

import com.bloggingApp.com.bloggApp_api.entities.Post;
import com.bloggingApp.com.bloggApp_api.payloads.PostDto;
import com.bloggingApp.com.bloggApp_api.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId , Integer categoryId);

//    update
    PostDto updatePost(PostDto postDto , Integer postId);

//    delete
    void deletePost(Integer  postId);

//    get all posts

    PostResponse getAllPost(Integer pageNumber , Integer pageSize, String sortBy, String sortDir);


//    get single post
    PostDto getPostById(Integer  postId);

//    get all posts by category
    List<PostDto> getPostsByCategory(Integer categoryId);

//     get all post by user
    List<PostDto> getPostsByUser(Integer userId);

//    search post
    List<PostDto>searchPosts(String keyword);
}
