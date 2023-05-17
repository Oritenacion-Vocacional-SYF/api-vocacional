package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Prueba;
import com.example.sitapivocacional.repository.PruebaRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class PruebaServiceImpl implements PruebaService{
    private final PruebaRepository pruebaRepository;

    private Gson gson;

    public PruebaServiceImpl(PruebaRepository pruebaRepository) {
        this.pruebaRepository = pruebaRepository;
        gson= new Gson();
    }

    @Override
    public Prueba createPrueba(Prueba prueba) {
        return pruebaRepository.save(prueba);
    }
}
