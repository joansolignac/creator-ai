package com.ggilos.creatorai.modules.ai.controller;

import com.ggilos.creatorai.modules.ai.dto.request.ChangeProviderRequest;
import com.ggilos.creatorai.modules.ai.dto.response.ProviderAvailabilityResponse;
import com.ggilos.creatorai.modules.ai.dto.response.ProviderSelectionResponse;
import com.ggilos.creatorai.modules.ai.service.AiProviderRegistry;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiController {
    private final AiProviderRegistry aiProviderRegistry;

    @PostMapping("/provider")
    public ResponseEntity<ProviderSelectionResponse> selectProvider(
            @Valid @RequestBody ChangeProviderRequest request
    ) {
        return ResponseEntity
                .ok(aiProviderRegistry.selectProvider(request.provider()));
    }

    @GetMapping("/provider/status")
    public ResponseEntity<ProviderAvailabilityResponse> getCurrentProviderStatus() {
        return ResponseEntity
                .ok(
                        aiProviderRegistry.getCurrentProviderStatus()
                );
    }
}
