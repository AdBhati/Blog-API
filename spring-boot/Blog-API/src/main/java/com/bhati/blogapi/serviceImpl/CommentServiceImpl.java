package com.bhati.blogapi.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhati.blogapi.dto.ApiResponse;
import com.bhati.blogapi.model.Comment;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.CommentRepository;
import com.bhati.blogapi.repository.PostRepository;
import com.bhati.blogapi.repository.UserRepository;
import com.bhati.blogapi.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository,
            UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ApiResponse getComments() {

        List<Comment> comments = commentRepository.findAll();
        comments.stream().forEach(comment -> comment.setUserId(comment.getUser().getId()));

        return new ApiResponse(null, true, "", comments.size(), "Comment", comments);
    }

    @Override
    public ApiResponse createComments(Comment comment) {
        User user = userRepository.findByEmail("Aarya@gmail.com")
                .orElseThrow(() -> new UsernameNotFoundException("permission Denied"));

        comment.setUser(user);
        comment.setUserId(user.getId());
        commentRepository.save(comment);

        return new ApiResponse(comment.getId(), true, "", Arrays.asList(comment).size(), "Comment",
                Arrays.asList(comment));

    }

//    @Override
//    public ApiResponse createComments(Comment comment, String username) {
//        User user = userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("permission Denied"));
//
//        comment.setUser(user);
//        comment.setUserId(user.getId());
//        commentRepository.save(comment);
//
//        return new ApiResponse(comment.getId(), true, "", Arrays.asList(comment).size(), "Comment",
//                Arrays.asList(comment));
//
//    }

    @Override
    public ApiResponse update(UUID comId, Comment comment, String username) {
        userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Permission Denied"));
        Comment existingComment = commentRepository.findById(comId)
                .orElseThrow(() -> new UsernameNotFoundException("Comment not found"));

        existingComment.setContent(comment.getContent());

        commentRepository.save(existingComment);

        return new ApiResponse(comId, true, "", Arrays.asList(existingComment).size(), username,
                Arrays.asList(existingComment));
    }

}
