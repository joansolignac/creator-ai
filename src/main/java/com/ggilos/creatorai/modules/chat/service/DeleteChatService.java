package com.ggilos.creatorai.modules.chat.service;

import com.ggilos.creatorai.modules.chat.entity.Chat;
import com.ggilos.creatorai.modules.chat.helper.FindChatByIdHelper;
import com.ggilos.creatorai.modules.chat.repository.ChatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteChatService {
    private final ChatRepository chatRepository;
    private final FindChatByIdHelper findChatByIdHelper;

    @Transactional
    public void execute(UUID chatId) {
        Chat chat = findChatByIdHelper.execute(chatId);
        chatRepository.delete(chat);
    }
}
