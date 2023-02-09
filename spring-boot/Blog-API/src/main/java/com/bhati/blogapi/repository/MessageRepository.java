package com.bhati.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.blogapi.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

    // @Query(value = "SELECT m FROM Message m WHERE m.id IN (SELECT MAX(id) FROM
    // Message GROUP BY sender, receiver) " +
    // " AND (m.sender.id = :id OR m.receiver.id = :id)")
    // List<Message> findAllRecentMessages(@Param("id") Long id);

    // @Query(value = "SELECT m FROM Message m WHERE (m.sender.id = :userId AND
    // m.receiver.id = :companionId) OR " +
    // "(m.sender.id = :companionId AND m.receiver.id = :userId) ORDER BY
    // m.createdDate")
    // List<Message> findConversation(@Param("userId") Long userId,
    // @Param("companionId") Long companionId);

    // Message findFirstBySenderIdOrReceiverIdOrderByIdDesc(Long userId, Long
    // theSameUserId);

}
