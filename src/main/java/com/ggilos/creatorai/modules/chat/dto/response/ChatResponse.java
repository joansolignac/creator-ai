package com.ggilos.creatorai.modules.chat.dto.response;

import com.ggilos.creatorai.modules.chat.entity.Chat;

import java.util.UUID;

public record ChatResponse(
        UUID chatId,
        int userId,
        String title
) {

    public static ChatResponse from(Chat chat) {
        return new ChatResponse(
                chat.getId(),
                chat.getUserId(),
                chat.getTitle()
        );
    }
}
