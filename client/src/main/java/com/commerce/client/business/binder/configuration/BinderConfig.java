package com.commerce.client.business.binder.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class BinderConfig {

    @Bean
    BasicAuthRequestInterceptor basicAuthRequestInterceptor() {

        return new BasicAuthRequestInterceptor("admin", "admin", StandardCharsets.UTF_8);
    }
}
