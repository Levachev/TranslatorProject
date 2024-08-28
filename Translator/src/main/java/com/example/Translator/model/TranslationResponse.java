package com.example.Translator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TranslationResponse implements Serializable {
    private String sourceLanguage;
    private String targetLanguage;
    private String text;
}
