package com.ggilos.creatorai.modules.chat.service;

import com.ggilos.creatorai.modules.chat.dto.response.ChatResponse;
import com.ggilos.creatorai.modules.chat.entity.Chat;
import com.ggilos.creatorai.modules.chat.helper.FindChatByIdHelper;
import com.ggilos.creatorai.modules.chat.repository.ChatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateChatTitleService {
    private final ChatRepository chatRepository;
    private final FindChatByIdHelper findChatByIdHelper;

    @Transactional
    public ChatResponse execute(UUID chatId, String title) {
        Chat chat = findChatByIdHelper.execute(chatId);

        if (title != null) chat.setTitle(title);

        chatRepository.save(chat);

        return ChatResponse.from(chat);
    }
}
