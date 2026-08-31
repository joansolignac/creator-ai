package com.ggilos.creatorai.modules.chat.helper;

import com.ggilos.creatorai.modules.chat.entity.Chat;
import com.ggilos.creatorai.modules.chat.exception.ChatNotFoundException;
import com.ggilos.creatorai.modules.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindChatByIdHelper {
    private final ChatRepository chatRepository;

    public Chat execute(UUID chatId) {
        return chatRepository.findById(chatId)
                .orElseThrow(
                        () -> new ChatNotFoundException(chatId)
                );
    }
}
