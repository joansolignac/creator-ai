package com.ggilos.creatorai.modules.ai.exception;

import com.ggilos.creatorai.common.exception.DomainException;
import com.ggilos.creatorai.common.exception.ErrorCode;
import com.ggilos.creatorai.modules.ai.enums.AiProvider;

public class ProviderNotAvailableException extends DomainException {
    public ProviderNotAvailableException() {
        super("Provider not available.", ErrorCode.PROVIDER_NOT_AVAILABLE);
    }
}
