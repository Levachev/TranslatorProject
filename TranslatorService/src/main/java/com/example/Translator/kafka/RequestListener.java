package com.example.Translator.kafka;

import com.example.Translator.model.TranslationRequest;
import com.example.Translator.model.TranslationResponse;
import com.example.Translator.service.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RequestListener {
    @Autowired
    private ResponseProducer producer;

    @Autowired
    private TranslationService apiTranslationService;

    @KafkaListener(topics = "translation.request",
            groupId = "group_id",
            containerFactory = "translationRequestListener")
    public void consume(TranslationRequest request) {
        log.info("consume request: {} {} {}",
                request.getSourceLanguage(), request.getTargetLanguage(), request.getText());
        producer.sendTranslationRequest(
                apiTranslationService.translate(request)
        );
    }
}
