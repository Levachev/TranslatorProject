package com.example.Translator.kafka;

import com.example.Translator.model.TranslationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ResponseListener {
    @Autowired
    private KafkaClient client;

    public TranslationResponse response;

    @KafkaListener(topics = "translation.response",
            groupId = "group_id",
            containerFactory = "translationResponseListener")
    public void consume(TranslationResponse response) {
        log.info("consume response: {} {} {}",
                response.getSourceLanguage(), response.getTargetLanguage(), response.getText());

        client.response = response;
    }
}
