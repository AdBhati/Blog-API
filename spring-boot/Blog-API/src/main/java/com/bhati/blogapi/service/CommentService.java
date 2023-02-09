package com.bhati.blogapi.service;

import java.util.UUID;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Comment;

public interface CommentService {

    ApiResponse getComments();

    ApiResponse createComments(Comment comment);
    //ApiResponse createComments(Comment comment, String username);

    ApiResponse update(UUID comId, Comment comment, String username);

}
