package com.ggilos.creatorai.modules.ai.controller;

import com.ggilos.creatorai.modules.ai.dto.request.ChangeProviderRequest;
import com.ggilos.creatorai.modules.ai.dto.response.ProviderResponse;
import com.ggilos.creatorai.modules.ai.dto.response.ProviderStatus;
import com.ggilos.creatorai.modules.ai.feature.AiRegistry;
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
    private final AiRegistry aiRegistry;

    @PostMapping("/provider")
    public ResponseEntity<ProviderResponse> changeProvider(
            @Valid @RequestBody ChangeProviderRequest request
    ) {
        return ResponseEntity
                .ok(aiRegistry.changeProvider(request.provider()));
    }

    @GetMapping("/provider/status")
    public ResponseEntity<ProviderStatus> getStatus() {
        return ResponseEntity
                .ok(
                        aiRegistry.getStatus()
                );
    }
}
