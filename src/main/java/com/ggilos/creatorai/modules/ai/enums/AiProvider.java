package com.ggilos.creatorai.modules.ai.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AiProvider {
    DEEPSEEK("deepseek"),
    NVIDIA("nvidia");

    public static final String DEEPSEEK_BEAN = "deepseek";
    public static final String NVIDIA_BEAN = "nvidia";

    private final String value;

    public String getBeanName() {
        return this.value;
    }
}
