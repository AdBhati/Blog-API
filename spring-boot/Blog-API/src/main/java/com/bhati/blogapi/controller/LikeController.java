package com.bhati.blogapi.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.service.LikeService;

@RestController
@RequestMapping("/likes")
@CrossOrigin
public class LikeController {

    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public ApiResponse getLike() {
        return likeService.getlike();
    }

    @PostMapping("/{postId}")
    public ApiResponse addLike(@PathVariable UUID postId, Principal principal) {
        return likeService.addLike(postId, principal.getName());
    }

}
