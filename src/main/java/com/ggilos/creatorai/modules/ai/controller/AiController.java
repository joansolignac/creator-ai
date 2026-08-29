package com.ggilos.creatorai.modules.ai.controller;

import com.ggilos.creatorai.modules.ai.dto.response.ProviderStatus;
import com.ggilos.creatorai.modules.ai.feature.AiRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiController {
    private final AiRegistry aiRegistry;

    @GetMapping("/provider/status")
    public ResponseEntity<ProviderStatus> getStatus() {
        return ResponseEntity
                .ok(
                        aiRegistry.getStatus()
                );
    }
}
