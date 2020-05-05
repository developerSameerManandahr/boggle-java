package com.assignment.boggle.configuration;

import com.assignment.boggle.cache.Cache;
import com.assignment.boggle.cache.InMemoryCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Cache getCache() {
        return new InMemoryCache();
    }
}
