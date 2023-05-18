package com.example.sitapivocacional.controller;

import com.example.sitapivocacional.model.*;
import com.example.sitapivocacional.service.UsuarioServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/SYF/usuarios")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioService;
    private Gson gson;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
        gson = new Gson();
    }

    @PostMapping("/admins")
    public ResponseEntity<Usuario> registrarAdmin(@RequestParam String cod_admin, @RequestParam String nom, @RequestParam String ape, @RequestParam String pswd) {
        return new ResponseEntity<>(usuarioService.createUsuario(new Administrador(nom, ape, pswd, cod_admin)), HttpStatus.CREATED);
    }

    @PostMapping("/estudiantes")
    public ResponseEntity<Usuario> registrarEstudiante(@RequestParam String nom, @RequestParam String ape, @RequestParam String pswd, @RequestParam int edad, @RequestParam String correo, @RequestParam String img, @RequestParam String desc) {
        return new ResponseEntity<>(usuarioService.createUsuario(new Estudiante(nom, ape, pswd, edad, correo, img, desc, gson.toJson(new ArrayList<CuestionarioTerminado>()), gson.toJson(new ArrayList<PruebaTerminada>()), gson.toJson(new ArrayList<String>()), gson.toJson(new ArrayList<String>()), gson.toJson(new ArrayList<String>()))), HttpStatus.CREATED);
    }

    @PatchMapping("/admins/{id}/modificar")
    public ResponseEntity<?> modificarAdmin(@PathVariable int id, @RequestParam String atributo, @RequestParam String valor){
        if(usuarioService.existsUsuario(id))
            if(usuarioService.getUsuarioById(id).getTipo().equals("admin"))
                return ResponseEntity.ok(usuarioService.updateAdmin(id, atributo, valor));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el admin.");
    }

    @PatchMapping("/estudiantes/{id}/modificar")
    public ResponseEntity<?> modificarEstudiante(@PathVariable int id, @RequestParam String atributo, @RequestBody String valor){
        if(usuarioService.existsUsuario(id))
            if(usuarioService.getUsuarioById(id).getTipo().equals("estudiante"))
                return ResponseEntity.ok(usuarioService.updateEstudiante(id, atributo, valor));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el estudiante.");
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<?> borrarUsuario(@PathVariable int id){
        if(usuarioService.existsUsuario(id)){
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el usuario.");
        }
    }

    @GetMapping("/admins")
    public ResponseEntity<List<Usuario>> obtenerAdmins(){
        return ResponseEntity.ok(usuarioService.getAllAdmins());
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<Usuario>> obtenerEstudiantes(){
        return ResponseEntity.ok(usuarioService.getAllEstudiantes());
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }




}
