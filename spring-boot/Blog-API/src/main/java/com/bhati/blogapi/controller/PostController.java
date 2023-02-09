package com.bhati.blogapi.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Post;
import com.bhati.blogapi.service.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ApiResponse getPosts() {
        return postService.getPosts();
    }

    @PostMapping
    public ApiResponse create(@RequestBody Post post) {
        return postService.create(post);
    }

    //    @PostMapping
//        public ApiResponse create(@RequestBody Post post, Principal principal) {
//        return postService.create(post, principal.getName());
//
//    }
    @PutMapping("/{postId}")
    public ApiResponse update(@PathVariable UUID postId, @RequestBody Post post, Principal principal) {
        return postService.update(postId, post, principal.getName());
    }

    //    @PutMapping("/{postId}")
//    public ApiResponse update(@PathVariable UUID postId, @RequestBody Post post, Principal principal) {
//        return postService.update(postId, post, principal.getName());
//    }
    @GetMapping("/profile/{userId}")
    public ApiResponse findByUserId(@PathVariable UUID userId) {
        return postService.findByUserId(userId);
    }
}





