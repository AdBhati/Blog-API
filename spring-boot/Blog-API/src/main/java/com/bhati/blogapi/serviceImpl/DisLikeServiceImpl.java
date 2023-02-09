package com.bhati.blogapi.serviceImpl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Dislike;
import com.bhati.blogapi.model.Post;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.DislikeRepository;
import com.bhati.blogapi.repository.PostRepository;
import com.bhati.blogapi.repository.UserRepository;
import com.bhati.blogapi.service.DisLikeService;

@Service
public class DisLikeServiceImpl implements DisLikeService {

    private final PostRepository postRepository;
    private final DislikeRepository dislikeRepository;
    private final UserRepository userRepository;

    public DisLikeServiceImpl(PostRepository postRepository, DislikeRepository dislikeRepository,
            UserRepository userRepository) {
        this.postRepository = postRepository;
        this.dislikeRepository = dislikeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse getDislike() {
        List<Dislike> dislikes = dislikeRepository.findAll();
        dislikes.stream().forEach(dislike -> dislike.setUserId(dislike.getUser().getId()));
        return new ApiResponse(null, true, "", dislikes.size(), "dislike", dislikes);
    }

    @Override
    public ApiResponse addDislike(UUID postId, String username) {

        User user = userRepository.findByEmail(username).orElse(null);
        Post post = postRepository.findById(postId).orElseThrow(() -> new UsernameNotFoundException("Post not Found"));
        Dislike existingdislike = dislikeRepository.findByPostIdAndUserId(postId, user.getId());

        if (existingdislike != null) {
            dislikeRepository.delete(existingdislike);
            return new ApiResponse(postId, true, "", Arrays.asList(post).size(), "post", Arrays.asList(post));
        } else {
            Dislike newdislike = new Dislike();
            newdislike.setPost(post);
            newdislike.setUser(user);
            newdislike.setCreatedDate(new Timestamp(0));
            newdislike.setUpdatedDate(new Timestamp(0));
            dislikeRepository.save(newdislike);

            return new ApiResponse(postId, true, "", Arrays.asList(post).size(), "post", Arrays.asList(post));

        }

        // if (post.getId() != null) {
        // dislike.setPost(post);
        // dislikeRepository.save(dislike);
        // }
        // return new ApiResponse(postId, true, " ", Arrays.asList(post).size(), "post",
        // Arrays.asList(post));
        // }
    }
}
