package com.example.sitapivocacional.controller;

import com.example.sitapivocacional.model.Prueba;
import com.example.sitapivocacional.service.PruebaServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/SYF/pruebas")
public class PruebaController {
    private final PruebaServiceImpl pruebaService;

    private Gson gson;

    public PruebaController(PruebaServiceImpl pruebaService, Gson gson) {
        this.pruebaService = pruebaService;
        this.gson = gson;
    }

    @PostMapping
    public ResponseEntity<Prueba> registrarPrueba(@RequestParam String id, @RequestBody String listaPreguntas){
        return new ResponseEntity<>(pruebaService.createPrueba(new Prueba(id, listaPreguntas)), HttpStatus.CREATED);
    }
}
