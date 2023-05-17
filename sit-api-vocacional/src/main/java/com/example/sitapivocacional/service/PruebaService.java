package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Prueba;

import java.util.List;

public interface PruebaService {
    Prueba createPrueba(Prueba prueba);

    List<Prueba> getAllPruebas();

    boolean existsPrueba(String id);

    Prueba getPruebaById(String id);
}
