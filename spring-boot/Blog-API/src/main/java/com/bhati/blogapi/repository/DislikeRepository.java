package com.bhati.blogapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bhati.blogapi.model.Dislike;

public interface DislikeRepository extends JpaRepository<Dislike, UUID> {

    @Query(value = "SELECT * FROM dislike WHERE post_Id = ?1 AND user_Id = ?2", nativeQuery = true)
    Dislike findByPostIdAndUserId(UUID postId, UUID userId);

}
