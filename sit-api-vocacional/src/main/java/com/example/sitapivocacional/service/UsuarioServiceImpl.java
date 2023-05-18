package com.example.sitapivocacional.service;

import com.example.sitapivocacional.model.Administrador;
import com.example.sitapivocacional.model.Estudiante;
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

    @Override
    public Usuario updateAdmin(int id, String atributo, String valor) {
        Administrador admin= (Administrador) getUsuarioById(id);

        switch (atributo.toLowerCase()){
            case "nombre": admin.setNombre(valor);
                break;

            case "apellido": admin.setApellido(valor);
                break;

            case "password": admin.setPassword(valor);
                break;
        }

        return usuarioRepository.save(admin);
    }

    @Override
    public Usuario updateEstudiante(int id, String atributo, String valor) {
        Estudiante est= (Estudiante) getUsuarioById(id);

        switch (atributo.toLowerCase()){
            case "nombre": est.setNombre(valor);
                break;

            case "apellido": est.setApellido(valor);
                break;

            case "password": est.setPassword(valor);
                break;

            case "edad": est.setEdad(Integer.parseInt(valor));
                break;

            case "correo": est.setCorreo(valor);
                break;

            case "image": est.setImage(valor);
                break;

            case "descripcion": est.setDescripcion(valor);
                break;

            case "habilidades": est.setHabilidades(valor);
                break;

            case "intereses": est.setIntereses(valor);
                break;

            case "valores": est.setValores(valor);
                break;
        }

        return usuarioRepository.save(est);
    }

    @Override
    public boolean existsUsuario(int id) {
        return usuarioRepository.existsById(id);
    }

    @Override
    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getAllAdmins() {
        return getAllUsuarios().stream().filter(ad -> ad.getTipo().equals("admin")).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> getAllEstudiantes() {
        return getAllUsuarios().stream().filter(est -> est.getTipo().equals("estudiante")).collect(Collectors.toList());
    }

}
