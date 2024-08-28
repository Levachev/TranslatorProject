package com.example.Translator.kafka;

import com.example.Translator.model.TranslationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RequestProducer {
    @Autowired
    private KafkaTemplate<String, TranslationRequest> kafkaTemplate;

    private static final String TOPIC = "translation.request";

    public void sendTranslationRequest(TranslationRequest request){
        kafkaTemplate.send(TOPIC, request);
        log.info("send request: {} {} {}",
                request.getSourceLanguage(), request.getTargetLanguage(), request.getText());
    }
}
