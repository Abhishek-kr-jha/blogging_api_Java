package com.bloggingApp.com.bloggApp_api.payloads;

import com.bloggingApp.com.bloggApp_api.entities.Category;
import com.bloggingApp.com.bloggApp_api.entities.Comment;
import com.bloggingApp.com.bloggApp_api.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto  category;

    private UserDto  user;
    private Integer postId;

    private Set<Comment> comments = new HashSet<>();


}
