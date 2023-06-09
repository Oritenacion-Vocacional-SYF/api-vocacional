package com.example.sitapivocacional.controller;

import com.example.sitapivocacional.model.Prueba;
import com.example.sitapivocacional.service.PruebaServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Prueba>> obtenerPruebas(){
        return ResponseEntity.ok(pruebaService.getAllPruebas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUnaPrueba(@PathVariable String id){
        if(pruebaService.existsPrueba(id))
            return ResponseEntity.ok(pruebaService.getPruebaById(id));
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la prueba.");
        }
    }

    @PatchMapping("/{id}/modificar")
    public ResponseEntity<?> modificarPrueba(@PathVariable String id, @RequestBody String listaPreguntas){
        if(pruebaService.existsPrueba(id))
            return ResponseEntity.ok(pruebaService.updatePrueba(id, listaPreguntas));
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la prueba.");
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<?> borrarUnaPrueba(@PathVariable String id){
        if(pruebaService.existsPrueba(id)){
            pruebaService.deletePrueba(id);
            return ResponseEntity.ok("Prueba eliminada correctamente.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la prueba.");
        }
    }
}
