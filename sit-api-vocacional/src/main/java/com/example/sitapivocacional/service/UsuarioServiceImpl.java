package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Usuario;
import com.example.sitapivocacional.repository.UsuarioRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;
    private Gson gson;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.gson = new Gson();
    }


    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
