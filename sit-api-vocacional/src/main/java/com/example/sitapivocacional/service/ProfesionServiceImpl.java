package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Profesion;
import com.example.sitapivocacional.repository.ProfesionRepository;
import org.springframework.stereotype.*;
import java.util.List;

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
    @Override
    public List<Profesion> getAllProfesiones() {
        return profesionRepository.findAll();
    }

    @Override
    public boolean existsProfesion(String id) {
        return profesionRepository.existsById(id);
    }

    @Override
    public Profesion getProfesionById(String id) {
        return profesionRepository.findById(id).get();
    }

}
