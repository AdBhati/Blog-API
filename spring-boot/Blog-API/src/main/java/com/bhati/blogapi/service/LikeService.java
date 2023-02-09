package com.bhati.blogapi.service;

import java.util.UUID;

import com.bhati.blogapi.dto.ApiResponse;

public interface LikeService {

    ApiResponse getlike();

    ApiResponse addLike(UUID postId, String username);

}
