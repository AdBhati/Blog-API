package com.bhati.blogapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.blogapi.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

}
