package com.ggilos.creatorai.modules.ai.dto.response;

import com.ggilos.creatorai.modules.ai.enums.AiProvider;

public record ProviderAvailabilityResponse(
        AiProvider provider,
        boolean available
) {
}
