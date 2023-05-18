package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Profesion;

import java.util.List;

public interface ProfesionService {

    Profesion createProfesion(Profesion profesion);
    List<Profesion> getAllProfesiones();
    boolean existsProfesion(String id);

    Profesion getProfesionById(String id);

}
