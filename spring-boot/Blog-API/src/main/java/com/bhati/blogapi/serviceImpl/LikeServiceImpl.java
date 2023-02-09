package com.bhati.blogapi.serviceImpl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Like;
import com.bhati.blogapi.model.Post;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.LikeRepository;
import com.bhati.blogapi.repository.PostRepository;
import com.bhati.blogapi.repository.UserRepository;
import com.bhati.blogapi.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;

    public LikeServiceImpl(PostRepository postRepository, LikeRepository likeRepository,
            UserRepository userRepository) {
        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse getlike() {

        List<Like> likes = likeRepository.findAll();
        likes.stream().forEach(like -> like.setUserId(like.getUser().getId()));
        return new ApiResponse(null, true, "", likes.size(), "Like", likes);
    }

    @Override
    public ApiResponse addLike(UUID postId, String username) {

        User user = userRepository.findByEmail(username).orElse(null);
        Post post = postRepository.findById(postId).orElseThrow(() -> new UsernameNotFoundException("Post Not Found"));
        Like existingLike = likeRepository.findByPostIdAndUserId(postId, user.getId());

        if (existingLike != null) {
            likeRepository.delete(existingLike);
            return new ApiResponse(postId, true, "", Arrays.asList(post).size(), "Post", Arrays.asList(post));
        } else {
            Like newLike = new Like();
            newLike.setPost(post);
            newLike.setUser(user);
            newLike.setCreatedDate(new Timestamp(0));
            newLike.setUpdatedDate(new Timestamp(0));
            likeRepository.save(newLike);

            return new ApiResponse(postId, true, "", Arrays.asList(post).size(), "Post", Arrays.asList(post));
        }

        // User user = userRepository.
        // Post post = postRepository.findById(postId).orElse(null);
        // if (post.getId() != null) {

        // like.setPost(post);
        // likeRepository.save(like);
        // }
        // return new ApiResponse(postId, true, "", Arrays.asList(post).size(), "Post",
        // Arrays.asList(post));

    }

}
