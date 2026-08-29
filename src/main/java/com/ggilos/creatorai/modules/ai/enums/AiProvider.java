package com.ggilos.creatorai.modules.ai.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AiProvider {
    DEEPSEEK("deepseek");

    public static final String DEEPSEEK_BEAN = "deepseek";

    private final String value;

    public String getBeanName() {
        return this.value;
    }
}
