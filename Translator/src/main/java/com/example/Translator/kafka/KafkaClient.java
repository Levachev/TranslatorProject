package com.example.Translator.kafka;

import com.example.Translator.model.TranslationRequest;
import com.example.Translator.model.TranslationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaClient {
    @Autowired
    private RequestProducer producer;

    public TranslationResponse response;

    public TranslationResponse translate(TranslationRequest request) throws InterruptedException {
        /*Thread.sleep(500);
        return new TranslationResponse(
                request.getSourceLanguage(),
                request.getTargetLanguage(),
                request.getContent()
        );*/
        response = null;
        producer.sendTranslationRequest(request);
        while (response == null){
            Thread.sleep(1000);
        }

        return response;
    }
}
