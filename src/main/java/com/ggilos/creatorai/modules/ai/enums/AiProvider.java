package com.ggilos.creatorai.modules.ai.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AiProvider {
    DEEPSEEK("deepseek");

    public static final String DEEPSEEK_BEAN_NAME = "deepseek";

    private final String beanName;
}
