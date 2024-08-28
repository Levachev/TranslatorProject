package com.example.Translator.service;

import com.example.Translator.kafka.KafkaClient;
import com.example.Translator.model.TranslationRequest;
import com.example.Translator.model.TranslationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationServiceImpl implements TranslationService{
    private final KafkaClient client;

    @Override
    @Cacheable("translation")
    public TranslationResponse translate(TranslationRequest request) throws InterruptedException {
        return client.translate(request);
    }
}
