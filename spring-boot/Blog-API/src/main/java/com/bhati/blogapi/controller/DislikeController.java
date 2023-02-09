package com.bhati.blogapi.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.service.DisLikeService;

@RestController
@RequestMapping("/dislikes")
public class DislikeController {

    private final DisLikeService disLikeService;

    public DislikeController(DisLikeService disLikeService) {
        this.disLikeService = disLikeService;
    }

    @GetMapping
    public ApiResponse getDislike() {
        return disLikeService.getDislike();

    }

    @PostMapping("/{postId}")
    public ApiResponse addDislike(@PathVariable UUID postId, Principal principal) {
        return disLikeService.addDislike(postId, principal.getName());
    }
}
