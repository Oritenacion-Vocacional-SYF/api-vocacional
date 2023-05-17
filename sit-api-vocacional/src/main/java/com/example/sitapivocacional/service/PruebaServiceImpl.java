package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Prueba;
import com.example.sitapivocacional.repository.PruebaRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Prueba> getAllPruebas() {
        return pruebaRepository.findAll();
    }

    @Override
    public boolean existsPrueba(String id) {
        return pruebaRepository.existsById(id);
    }

    @Override
    public Prueba getPruebaById(String id) {
        return pruebaRepository.findById(id).get();
    }

    @Override
    public Prueba updatePrueba(String id, String listaPreguntas) {
        Prueba prue= getPruebaById(id);

        prue.setPreguntas(listaPreguntas);

        return pruebaRepository.save(prue);
    }
}
