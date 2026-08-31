package com.ggilos.creatorai.modules.chat.service;

import com.ggilos.creatorai.common.dto.response.PaginationResponse;
import com.ggilos.creatorai.modules.chat.dto.response.ChatResponse;
import com.ggilos.creatorai.modules.chat.entity.Chat;
import com.ggilos.creatorai.modules.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindChatsByUserId {
    private final ChatRepository chatRepository;

    public PaginationResponse<ChatResponse> execute(int userId, Pageable pageable) {
        Slice<Chat> slice = chatRepository.findByUserId(userId, pageable);

        return PaginationResponse
                .from(
                        slice.map(
                                ChatResponse::from
                        )
                );
    }
}
