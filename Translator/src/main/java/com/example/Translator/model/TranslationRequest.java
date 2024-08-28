package com.example.Translator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TranslationRequest {
    private String sourceLanguage;
    private String targetLanguage;
    private String text;
}
