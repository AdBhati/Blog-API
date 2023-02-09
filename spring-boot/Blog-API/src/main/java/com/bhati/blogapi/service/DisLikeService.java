package com.bhati.blogapi.service;

import java.util.UUID;

import com.bhati.blogapi.dto.ApiResponse;

public interface DisLikeService {

    ApiResponse getDislike();

    ApiResponse addDislike(UUID postId, String username);

}
