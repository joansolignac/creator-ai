package com.ggilos.creatorai.modules.ai.config;

import com.ggilos.creatorai.modules.ai.enums.AiProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class AiModelConfiguration {
    private final AiProperties aiProperties;

    @Primary
    @Bean(AiProvider.DEEPSEEK_BEAN_NAME)
    public ChatModel deepseekChatModel() {
        var deepseekProperties = aiProperties.getProviders().get(AiProvider.DEEPSEEK);

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

    @Bean("aiProviderModels")
    public Map<AiProvider, ChatModel> aiProviderModels(
            @Qualifier(AiProvider.DEEPSEEK_BEAN_NAME) ChatModel deepseekChatModel
    ) {
        return Map.of(
                AiProvider.DEEPSEEK, deepseekChatModel
        );
    }
}
