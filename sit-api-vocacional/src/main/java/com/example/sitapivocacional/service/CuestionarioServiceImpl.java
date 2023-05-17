package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Cuestionario;
import com.example.sitapivocacional.repository.CuestionarioRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuestionarioServiceImpl implements CuestionarioService{

    private final CuestionarioRepository cuestionarioRepository;

    private Gson gson;

    public CuestionarioServiceImpl(CuestionarioRepository cuestionarioRepository) {
        this.cuestionarioRepository = cuestionarioRepository;
        gson= new Gson();
    }

    @Override
    public Cuestionario createCuestionario(Cuestionario cuestionario) {
        return cuestionarioRepository.save(cuestionario);
    }

    @Override
    public List<Cuestionario> getAllCuestionarios() {
        return cuestionarioRepository.findAll();
    }

    @Override
    public boolean existsCuestionario(String id) {
        return cuestionarioRepository.existsById(id);
    }

    @Override
    public Cuestionario getCuestionarioById(String id) {
        return cuestionarioRepository.findById(id).get();
    }
}
