package com.example.Translator.service;

import com.example.Translator.model.TranslationRequest;
import com.example.Translator.model.TranslationResponse;

public interface TranslationService {
    TranslationResponse translate(TranslationRequest request);
}
