package com.ggilos.creatorai.modules.ai.exception;

import com.ggilos.creatorai.common.exception.DomainException;
import com.ggilos.creatorai.common.exception.ErrorCode;

public class EmptyProviderResponseException extends DomainException {
    public EmptyProviderResponseException() {

        super("Empty provider response.", ErrorCode.EMPTY_PROVIDER_RESPONSE);
    }
}
