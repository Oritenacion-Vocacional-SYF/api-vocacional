package com.example.sitapivocacional.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String tipo;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    @Column(name="password", nullable = false)
    //@JsonIgnore
    private String password;

    public Usuario(String tipo, String nombre, String apellido, String password) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

}
