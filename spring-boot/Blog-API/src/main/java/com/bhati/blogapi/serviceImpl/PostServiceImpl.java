package com.bhati.blogapi.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.bhati.blogapi.dto.PostDto;
import com.bhati.blogapi.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Post;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.PostRepository;
import com.bhati.blogapi.repository.UserRepository;
import com.bhati.blogapi.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override // get all post
    public ApiResponse getPosts() {

        List<Post> posts = postRepository.findAll();
        posts.stream().forEach(post -> post.setUserId(post.getUser().getId()));

        return new ApiResponse(null, true, "", posts.size(), "Post", posts);
    }

    // create post by user
    @Override
    public ApiResponse create(Post post) {
        User user = userRepository.findByEmail("Aarya@gmail.com")
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        post.setUser(user);
        post.setUserId(user.getId());
        postRepository.save(post);

        return new ApiResponse(post.getId(), true, "", Arrays.asList(post).size(), "Post", Arrays.asList(post));
    }

//    @Override
//    public ApiResponse create(Post post, String username) {
//        User user = userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
//
//        post.setUser(user);
//        post.setUserId(user.getId());
//        postRepository.save(post);
//
//        return new ApiResponse(post.getId(), true, "", Arrays.asList(post).size(), "Post", Arrays.asList(post));
//    }


    @Override   // update post
    public ApiResponse update(UUID postId, Post post, String username) {
        userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Permission Denied"));
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new UsernameNotFoundException("Post Not Found"));

        existingPost.setContent(post.getContent());
        existingPost.setImageurl(post.getImageurl());

        postRepository.save(existingPost);

        return new ApiResponse(postId, true, "", Arrays.asList(existingPost).size(), username,
                Arrays.asList(existingPost));

    }

    @Override // get profile information of user
    public ApiResponse findByUserId(UUID userId) {
        List<Post> posts = postRepository.findByUserId(userId);
            UserDto userDto = modelMapper.map(posts.stream().map(p-> p.getUser()).findFirst().orElse(null), UserDto.class);

        List<PostDto> postDtos = new ArrayList<>();
        posts.stream().forEach(post-> {
            postDtos.add(modelMapper.map(post, PostDto.class));
        });

        postDtos.stream().forEach(post -> {
            post.setUserDto(userDto);
            post.setAddress(userDto.getAddress());
        });
        return new ApiResponse(userId, true, "",Arrays.asList(postDtos).size(),"postDtos",Arrays.asList(postDtos));
    }




}
