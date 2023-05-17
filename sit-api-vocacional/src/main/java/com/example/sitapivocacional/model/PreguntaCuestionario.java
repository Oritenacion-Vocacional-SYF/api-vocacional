package com.example.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PreguntaCuestionario {
    private String enunciado;

    private Map<Character, String> alternativas;

    @JsonIgnore
    private Map<Character, Integer> puntos;
}
