package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Cuestionario;
import com.example.sitapivocacional.repository.CuestionarioRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

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
}
