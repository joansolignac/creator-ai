package com.ggilos.creatorai.common.config;

import com.ggilos.creatorai.modules.ai.config.AiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AiProperties.class)
public class PropertiesConfig {
}
