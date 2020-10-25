package com.immfly.flightmanagment.service.feign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Client;
import feign.Feign;
import feign.okhttp.OkHttpClient;

@Configuration
public class FeignConfig {

	@Bean("Client")
	public Client okHttpClientBuilder() {
		return new OkHttpClient();
	}
	@Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
	
}
