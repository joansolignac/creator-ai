package com.ggilos.creatorai.modules.ai.config;

import com.ggilos.creatorai.modules.ai.enums.AiProvider;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix = "app.ai")
public class AiProperties {
    private Map<AiProvider, ProviderProperties> providers;

    public record ProviderProperties(
            String apiKey,
            String baseUrl,
            String model
    ) {}
}
