package com.orangehrmlive.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class BrowserScopeConfig {
    @Lazy
    @Bean
    public static BrowserScopePostProcessor browserScopePostProcessor() {
        return new BrowserScopePostProcessor();
    }
}
