package com.ggilos.creatorai.modules.ai.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AiProvider {
    DEEPSEEK("deepseek");

    public static final String DEEPSEEK_BEAN_NAME = "deepseek";

    private final String beanName;

    public String getBeanName() {
        return this.beanName;
    }
}
