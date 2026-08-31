package com.ggilos.creatorai.modules.chat.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateChatRequest(
        @Positive
        int userId,

        @NotBlank
        @Size(max = 255)
        String title
) {
}
