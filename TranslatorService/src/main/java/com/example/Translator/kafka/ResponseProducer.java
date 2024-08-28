package com.example.Translator.kafka;

import com.example.Translator.model.TranslationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ResponseProducer {
    @Autowired
    private KafkaTemplate<String, TranslationResponse> kafkaTemplate;

    private static final String TOPIC = "translation.response";

    public void sendTranslationRequest(TranslationResponse response){
        kafkaTemplate.send(TOPIC, response);
        log.info("send response: {} {} {}",
                response.getSourceLanguage(), response.getTargetLanguage(), response.getText());
    }
}
