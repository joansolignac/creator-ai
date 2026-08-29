package com.ggilos.creatorai.modules.ai.dto.request;

import com.ggilos.creatorai.modules.ai.enums.AiProvider;
import jakarta.validation.constraints.NotNull;

public record ChangeProviderRequest(
        @NotNull(message = "AI provider cannot be null.")
        AiProvider provider
) {
}
