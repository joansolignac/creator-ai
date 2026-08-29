package com.ggilos.creatorai.modules.ai.service;

import com.ggilos.creatorai.modules.ai.dto.response.ProviderAvailabilityResponse;
import com.ggilos.creatorai.modules.ai.dto.response.ProviderSelectionResponse;
import com.ggilos.creatorai.modules.ai.enums.AiProvider;
import com.ggilos.creatorai.modules.ai.exception.EmptyProviderResponseException;
import com.ggilos.creatorai.modules.ai.exception.ProviderNotAvailableException;
import com.ggilos.creatorai.modules.ai.exception.ProviderNotFoundException;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AiProviderRegistry {
    private final Map<AiProvider, ChatModel> providerModels;
    private final AtomicReference<AiProvider> currentProvider;
    private final AtomicReference<ChatModel> currentChatModel;

    public AiProviderRegistry(
            @Qualifier("aiProviderModels") Map<AiProvider, ChatModel> providerModels,
            ChatModel chatModel
    ) {
        this.providerModels = providerModels;
        this.currentProvider = new AtomicReference<>(AiProvider.DEEPSEEK);
        this.currentChatModel = new AtomicReference<>(chatModel);
    }
    
    public ProviderSelectionResponse selectProvider(AiProvider aiProvider) {
        ChatModel chatModel = this.providerModels.get(aiProvider);

        if (chatModel == null) {
            throw new ProviderNotFoundException(aiProvider);
        }

        this.validateModel(chatModel);

        this.currentProvider.set(aiProvider);
        this.currentChatModel.set(chatModel);

        return new ProviderSelectionResponse(
          aiProvider
        );
    }

    public ChatModel getCurrentChatModel() {
        return this.currentChatModel.get();
    }

    public ProviderAvailabilityResponse getCurrentProviderStatus() {
        this.validateModel(this.currentChatModel.get());
        return new ProviderAvailabilityResponse(
                true
        );
    }

    private void validateModel(ChatModel chatModel) {
        String validationPrompt = "REPLY ONLY WITH OK";

        try {
            ChatClient chatClient = ChatClient
                    .builder(chatModel)
                    .build();

            String response = chatClient
                    .prompt()
                    .user(validationPrompt)
                    .call()
                    .content();

            if (response == null || response.isBlank()) {
                throw new EmptyProviderResponseException();
            }
        } catch (Exception exception) {
            throw new ProviderNotAvailableException();
        }

    }
}
