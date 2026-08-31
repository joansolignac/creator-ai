package com.ggilos.creatorai.modules.chat.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UpdateChatTitleRequest(
        @NotBlank
        @Length(max = 255)
        String title
) {
}
