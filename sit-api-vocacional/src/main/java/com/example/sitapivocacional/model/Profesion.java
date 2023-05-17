package com.example.sitapivocacional.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="profesiones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profesion {

    @Id
    @Column(name="id_profesion", nullable = false)
    private String idProfesion;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="descripcion", nullable = false)
    private String descripcion;

    @Column(name="requisitos_admision", nullable = false)
    private String requisitosAdmision;

    @Column(name="perspectiva_laboral", nullable = false)
    private String perspectivaLaboral;

    @Column(name="salarios", nullable = false)
    private String salarios;

}
