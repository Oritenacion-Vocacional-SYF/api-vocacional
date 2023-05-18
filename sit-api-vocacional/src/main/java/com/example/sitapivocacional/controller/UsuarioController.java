package com.example.sitapivocacional.controller;

import com.example.sitapivocacional.model.*;
import com.example.sitapivocacional.service.UsuarioServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


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








}
