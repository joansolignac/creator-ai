package com.ggilos.creatorai.modules.ai.feature;

import com.ggilos.creatorai.modules.ai.dto.response.ProviderResponse;
import com.ggilos.creatorai.modules.ai.dto.response.ProviderStatus;
import com.ggilos.creatorai.modules.ai.enums.AiProvider;
import com.ggilos.creatorai.modules.ai.exception.EmptyProviderResponseException;
import com.ggilos.creatorai.modules.ai.exception.ProviderNotAvailableException;
import com.ggilos.creatorai.modules.ai.exception.ProviderNotFoundException;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class AiRegistry {
    private final Map<String, ChatModel> providers;
    private final AtomicReference<AiProvider> currentProvider;
    private final AtomicReference<ChatModel> currentChatModel;

    public AiRegistry(
            Map<String, ChatModel> providers,
            ChatModel chatModel
    ) {
        this.providers = providers;
        this.currentProvider = new AtomicReference<>(AiProvider.DEEPSEEK);
        this.currentChatModel = new AtomicReference<>(chatModel);
    }

    public ProviderResponse changeProvider(AiProvider aiProvider) {
        String beanName = aiProvider.getBeanName();

        ChatModel chatModel = this.providers.get(beanName);

        if (chatModel == null) {
            throw new ProviderNotFoundException(aiProvider);
        }

        this.validateModel(chatModel);

        this.currentProvider.set(aiProvider);
        this.currentChatModel.set(chatModel);

        return new ProviderResponse(
          aiProvider
        );
    }

    public ChatModel getCurrentChatModel() {
        return this.currentChatModel.get();
    }

    //Simple function to get the current status
    public ProviderStatus getStatus() {
        this.validateModel(this.currentChatModel.get());
        return new ProviderStatus(
                true
        );
    }

    private void validateModel(ChatModel chatModel) {
        String USER_MESSAGE = "REPLY ONLY WITH OK";

        try {
            ChatClient chatClient = ChatClient
                    .builder(chatModel)
                    .build();

            String response = chatClient
                    .prompt()
                    .user(USER_MESSAGE)
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
