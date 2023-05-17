package com.example.sitapivocacional.controller;

import com.example.sitapivocacional.model.Cuestionario;
import com.example.sitapivocacional.service.CuestionarioServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/SYF/cuestionarios")
public class CuestionarioController {

    private final CuestionarioServiceImpl cuestionarioService;

    private Gson gson;


    public CuestionarioController(CuestionarioServiceImpl cuestionarioService) {
        this.cuestionarioService = cuestionarioService;
        gson= new Gson();
    }

    @PostMapping
    public ResponseEntity<Cuestionario> registrarCuestionario(@RequestParam String id, @RequestBody String listaPreguntas){
        return new ResponseEntity<>(cuestionarioService.createCuestionario(new Cuestionario(id, listaPreguntas)), HttpStatus.CREATED);
    }
}
