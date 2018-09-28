package com.commerce.client.business.binder.configuration;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class BinderConfig {

	@Bean
	BasicAuthRequestInterceptor basicAuthRequestInterceptor() {

		return new BasicAuthRequestInterceptor("admin", "admin", StandardCharsets.UTF_8);
	}
}
