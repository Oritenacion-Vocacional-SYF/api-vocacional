package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Cuestionario;

import java.util.List;

public interface CuestionarioService {
    Cuestionario createCuestionario(Cuestionario cuestionario);

    List<Cuestionario> getAllCuestionarios();

    boolean existsCuestionario(String id);

    Cuestionario getCuestionarioById(String id);

    Cuestionario updateCuestionario(String id, String listaPreguntas);

    void deleteCuestionario(String id);
}
