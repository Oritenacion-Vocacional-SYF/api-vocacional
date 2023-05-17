package com.example.sitapivocacional.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PreguntaPrueba {
    private String enunciado;

    private Map<Character, String> alternativas;

    private char respCorrecta;
}
