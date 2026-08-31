package com.ggilos.creatorai.modules.chat.exception;

import com.ggilos.creatorai.common.exception.DomainException;
import com.ggilos.creatorai.common.exception.ErrorCode;

import java.util.UUID;

public class ChatNotFoundException extends DomainException {
    public ChatNotFoundException(UUID chatId) {
        super(String.format("Chat with chatId: '%s' not found.", chatId), ErrorCode.CHAT_NOT_FOUND);
    }
}
