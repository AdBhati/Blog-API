package com.bhati.blogapi.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Comment;
import com.bhati.blogapi.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ApiResponse getComments() {
        return commentService.getComments();
    }

    @PostMapping
    public ApiResponse createComments(@RequestBody Comment comment) {
        return commentService.createComments(comment);
    }

//    @PostMapping
//    public ApiResponse createComments(@RequestBody Comment comment) {
//        return commentService.createComments(comment, principal.getName());
//    }


    @PutMapping("/{comId}")
    public ApiResponse update(@PathVariable UUID comId, @RequestBody Comment comment, Principal principal) {
        return commentService.update(comId, comment, principal.getName());

    }

}
