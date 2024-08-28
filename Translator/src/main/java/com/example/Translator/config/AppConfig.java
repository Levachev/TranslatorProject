package com.example.Translator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CountDownLatch;

@Configuration
public class AppConfig {
    @Bean
    public CountDownLatch latch(){
        return new CountDownLatch(1);
    }
}
