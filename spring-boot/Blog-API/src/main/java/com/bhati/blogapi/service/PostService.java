package com.bhati.blogapi.service;

import java.util.UUID;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Post;

public interface PostService {

    ApiResponse getPosts();

    ApiResponse create(Post post);
//    ApiResponse create(Post post, String username);

    ApiResponse update(UUID postId, Post post, String username);

    ApiResponse findByUserId(UUID userId);



//    ApiResponse findPostsByUserId(UUID user)

}
