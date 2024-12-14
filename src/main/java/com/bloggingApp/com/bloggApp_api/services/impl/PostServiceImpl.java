package com.bloggingApp.com.bloggApp_api.services.impl;

import com.bloggingApp.com.bloggApp_api.entities.Category;
import com.bloggingApp.com.bloggApp_api.entities.Post;
import com.bloggingApp.com.bloggApp_api.entities.User;
import com.bloggingApp.com.bloggApp_api.exceptions.ResourceNotFoundException;
import com.bloggingApp.com.bloggApp_api.payloads.PostDto;
import com.bloggingApp.com.bloggApp_api.repositories.CategoryRepo;
import com.bloggingApp.com.bloggApp_api.repositories.PostRepo;
import com.bloggingApp.com.bloggApp_api.repositories.UserRepo;
import com.bloggingApp.com.bloggApp_api.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);

    }


    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

        Category category1 = post.getCategory();
        Category category = this.categoryRepo.findById(post.getCategory().getCategoryId()).get();

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        post.setCategory(category);


        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","post id ", postId));
        this.postRepo.delete(post);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPosts =  this.postRepo.findAll();
        List<PostDto>postDtos = allPosts.stream().map((post)->this.modelMapper.map(post,PostDto.class))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
       Post post =  this.postRepo.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("User","Post id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

        List<Post> posts = this.postRepo.findByCategory(cat);

        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User ", "userId", userId));
        List<Post> posts = this.postRepo.findAByUser(user);
        List<PostDto> postsDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
        return postsDtos;
    }
}
