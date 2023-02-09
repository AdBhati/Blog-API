package com.bhati.blogapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.blogapi.model.Post;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, UUID> {

    @Query(value = "SELECT * FROM Post WHERE user_id = ?1", nativeQuery = true)
    List<Post> findByUserId(UUID userId);

}
