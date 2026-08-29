package com.ggilos.creatorai.modules.ai.config;

import com.ggilos.creatorai.modules.ai.enums.AiProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RequiredArgsConstructor
public class AiConfig {
    private final AiProperties aiProperties;

    @Primary
    @Bean(AiProvider.DEEPSEEK_BEAN)
    public ChatModel deepSeekChatModel() {
        var deepseekProperties = aiProperties.getProviders().get(AiProvider.DEEPSEEK_BEAN);

        var options = OpenAiChatOptions
                .builder()
                .apiKey(deepseekProperties.apiKey())
                .baseUrl(deepseekProperties.baseUrl())
                .model(deepseekProperties.model())
                .build();

        return OpenAiChatModel
                .builder()
                .options(options)
                .build();
    }

}
