package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Profesion;
import com.example.sitapivocacional.repository.ProfesionRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesionServiceImpl implements ProfesionService{

    private final ProfesionRepository profesionRepository;
    public ProfesionServiceImpl(ProfesionRepository profesionRepository) {
        this.profesionRepository = profesionRepository;
    }

    @Override
    public Profesion createProfesion(Profesion profesion){
        return profesionRepository.save(profesion);
    }
}