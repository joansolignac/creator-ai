package com.ggilos.creatorai.modules.chat.service;

import com.ggilos.creatorai.modules.chat.dto.response.ChatResponse;
import com.ggilos.creatorai.modules.chat.entity.Chat;
import com.ggilos.creatorai.modules.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateChatService {
    private final ChatRepository chatRepository;

    public ChatResponse execute(int userId, String title) {
        Chat chat = chatRepository
                .save(
                        Chat
                                .builder()
                                .userId(userId)
                                .title(title)
                                .build()
                );

        return ChatResponse.from(chat);
    }
}
