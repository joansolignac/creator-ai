package com.ggilos.creatorai.modules.chat.controller;

import com.ggilos.creatorai.common.dto.request.PaginationRequest;
import com.ggilos.creatorai.common.dto.response.PaginationResponse;
import com.ggilos.creatorai.modules.chat.dto.request.CreateChatRequest;
import com.ggilos.creatorai.modules.chat.dto.request.UpdateChatTitleRequest;
import com.ggilos.creatorai.modules.chat.dto.response.ChatResponse;
import com.ggilos.creatorai.modules.chat.service.CreateChatService;
import com.ggilos.creatorai.modules.chat.service.DeleteChatService;
import com.ggilos.creatorai.modules.chat.service.FindChatsByUserId;
import com.ggilos.creatorai.modules.chat.service.UpdateChatTitleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {
    private final CreateChatService createChatService;
    private final DeleteChatService deleteChatService;
    private final FindChatsByUserId findChatsByUserId;
    private final UpdateChatTitleService updateChatTitleService;

    @PostMapping()
    public ResponseEntity<ChatResponse> create(
            @RequestBody @Valid CreateChatRequest body
            ) {
        ChatResponse response = createChatService.execute(body.userId(), body.title());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<PaginationResponse<ChatResponse>> findByUserId(
            @PathVariable int userId,
            @Valid PaginationRequest pagination
    ) {
        PaginationResponse<ChatResponse> response = findChatsByUserId.execute(
                userId,
                pagination.toPageable()
        );

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{chatId}")
    public ResponseEntity<ChatResponse> updateTitle(
            @PathVariable UUID chatId,
            @RequestBody @Valid UpdateChatTitleRequest body
            ) {
        ChatResponse response = updateChatTitleService.execute(chatId, body.title());

        return ResponseEntity
                .ok(
                        response
                );
    }

    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID chatId
    ) {
        deleteChatService.execute(chatId);

        return ResponseEntity.noContent().build();
    }
}
