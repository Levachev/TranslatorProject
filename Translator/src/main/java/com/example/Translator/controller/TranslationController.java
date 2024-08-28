package com.example.Translator.controller;

import com.example.Translator.model.TranslationRequest;
import com.example.Translator.model.TranslationResponse;
import com.example.Translator.service.TranslationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translation")
@RequiredArgsConstructor
public class TranslationController {
    private final TranslationService translationService;

    @PostMapping("/translate")
    public TranslationResponse translate(@RequestBody TranslationRequest request) throws InterruptedException {
        return  translationService.translate(request);
    }
}
