package com.ggilos.creatorai.modules.ai.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "app.ai")
public class AiProperties {
    private Map<String, ProviderConfig> providers;

    public record ProviderConfig(
            String apiKey,
            String baseUrl,
            String model
    ) {}
}
