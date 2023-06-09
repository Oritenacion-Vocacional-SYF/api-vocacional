package com.example.sitapivocacional.controller;


import com.example.sitapivocacional.model.Profesion;
import com.example.sitapivocacional.service.ProfesionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/SYF/profesiones")
public class ProfesionController {

    private final ProfesionServiceImpl profesionService;

    public ProfesionController(ProfesionServiceImpl profesionService) {
        this.profesionService = profesionService;
    }

    @PostMapping
    public ResponseEntity<Profesion> registrarProfesion(@RequestParam String id, @RequestParam String nom, @RequestParam String desc, @RequestParam String requisitos, @RequestParam String perspectiva, @RequestParam String salarios){
        return new ResponseEntity<>(profesionService.createProfesion(new Profesion(id, nom, desc, requisitos, perspectiva, salarios)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Profesion>> obtenerProfesiones(){
        return ResponseEntity.ok(profesionService.getAllProfesiones());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUnaProfesion(@PathVariable String id){
        if(profesionService.existsProfesion(id))
            return ResponseEntity.ok(profesionService.getProfesionById(id));
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la profesión.");
        }
    }
    @PatchMapping("/{id}/actualizar-datos")
    public ResponseEntity<?> modificarProfesion(@PathVariable String id, @RequestParam String atributo, @RequestParam String valor){
        if(profesionService.existsProfesion(id))
            return ResponseEntity.ok(profesionService.updateProfesion(id, atributo, valor));
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la profesión.");
        }
    }
    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<?> borrarUnaProfesion(@PathVariable String id){
        if(profesionService.existsProfesion(id)){
            profesionService.deleteProfesion(id);
            return ResponseEntity.ok("Profesión eliminada correctamente.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la profesión.");
        }
    }
}
