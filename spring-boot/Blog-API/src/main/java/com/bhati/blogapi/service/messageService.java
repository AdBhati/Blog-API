package com.bhati.blogapi.service;

import com.bhati.blogapi.dto.MessageDto;

public interface messageService {
    // List<MessageDto> findAllRecentMessages(Long id);

    // List<MessageDto> findConversation(Long userId, Long companionId);

    // MessageDto getRecentMessage(Long id);

    void postMessage(MessageDto messageDTO);

}
