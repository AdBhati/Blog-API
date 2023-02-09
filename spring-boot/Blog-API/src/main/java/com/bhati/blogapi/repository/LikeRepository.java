package com.bhati.blogapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bhati.blogapi.model.Like;

public interface LikeRepository extends JpaRepository<Like, UUID> {

    // Boolean findByPostIdAndUserId(UUID postId, UUID userId);
    @Query(value = "SELECT * FROM Likes WHERE post_Id = ?1 AND user_Id = ?2", nativeQuery = true)
    Like findByPostIdAndUserId(UUID postId, UUID userId);

}
