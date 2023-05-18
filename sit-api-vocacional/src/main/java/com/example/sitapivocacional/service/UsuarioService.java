package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario usuario);

    Usuario updateAdmin(int id, String atributo, String valor);

    Usuario updateEstudiante(int id, String atributo, String valor);


    boolean existsUsuario(int id);

    Usuario getUsuarioById(int id);

    void deleteUsuario(int id);

}
