package com.ggilos.creatorai.modules.ai.exception;

import com.ggilos.creatorai.common.exception.DomainException;
import com.ggilos.creatorai.common.exception.ErrorCode;
import com.ggilos.creatorai.modules.ai.enums.AiProvider;

public class ProviderNotFoundException extends DomainException {
    public ProviderNotFoundException(AiProvider provider) {
        super(String.format("Provider '%s' not found.", provider.getBeanName()), ErrorCode.PROVIDER_NOT_FOUND);
    }
}
