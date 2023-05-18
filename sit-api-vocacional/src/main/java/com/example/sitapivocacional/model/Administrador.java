package com.example.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Administrador extends Usuario{

    @Column(name="codigo_admin")
    private String codigoAdmin;

    public Administrador(String nombre, String apellido, String password, String codigoAdmin) {
        super("admin", nombre, apellido, password);
        this.codigoAdmin = codigoAdmin;
    }

}
