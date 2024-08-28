package com.example.Translator.service;

import com.example.Translator.model.TranslationRequest;
import com.example.Translator.model.TranslationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiTranslationService implements TranslationService{
    @Autowired
    private RestClient translationRestClient;

    @Override
    public TranslationResponse translate(TranslationRequest request){
        //TODO find real free translate api and translate text
        /*return translationRestClient
                .post()
                .uri("")
                .header("", "")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(TranslationResponse.class);*/
        return new TranslationResponse(
                request.getSourceLanguage(),
                request.getTargetLanguage(),
                request.getText()
        );
    }
}
