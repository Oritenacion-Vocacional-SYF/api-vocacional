package com.example.sitapivocacional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estudiante extends Usuario{


    @Column(name="edad")
    private int edad;

    @Column(name="correo")
    private String correo;

    @Column(name="image")
    private String image;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="fecha_registro")
    private LocalDate fechaRegistro;

    @Lob
    @Column(name="cuestionarios")
    @JsonIgnore
    private String cuestionarios;

    @Lob
    @Column(name="pruebas")
    @JsonIgnore
    private String pruebas;

    @Lob
    @Column(name="habilidades")
    @JsonIgnore
    private String habilidades;

    @Lob
    @Column(name="intereses")
    @JsonIgnore
    private String intereses;

    @Lob
    @Column(name="valores")
    @JsonIgnore
    private String valores;

    public Estudiante(String nombre, String apellido, String password, int edad, String correo, String cuestionarios, String pruebas, String habilidades, String intereses, String valores) {
        super("estudiante", nombre, apellido, password);
        this.edad = edad;
        this.correo = correo;
        this.fechaRegistro= LocalDate.now();
        this.cuestionarios = cuestionarios;
        this.pruebas = pruebas;
        this.habilidades = habilidades;
        this.intereses = intereses;
        this.valores = valores;
    }

    public Estudiante(String nombre, String apellido, String password, int edad, String correo, String image, String descripcion, String cuestionarios, String pruebas, String habilidades, String intereses, String valores) {
        super("estudiante", nombre, apellido, password);
        this.edad = edad;
        this.correo = correo;
        this.image = image;
        this.descripcion = descripcion;
        this.fechaRegistro = LocalDate.now();
        this.cuestionarios = cuestionarios;
        this.pruebas = pruebas;
        this.habilidades = habilidades;
        this.intereses = intereses;
        this.valores = valores;
    }

    public List<String> getListaHabilidades(){
        return new Gson().fromJson(this.habilidades, List.class);
    }

    public List<String> getListaIntereses(){
        return new Gson().fromJson(this.intereses, List.class);
    }

    public List<String> getListaValores(){
        return new Gson().fromJson(this.valores, List.class);
    }

    public List<CuestionarioTerminado> getListaCuestionarios(){
        Type listaCuestionarioTerminadoType = new TypeToken<List<CuestionarioTerminado>>() {}.getType();
        return new Gson().fromJson(this.cuestionarios, listaCuestionarioTerminadoType);
    }

    public List<PruebaTerminada> getListaPruebas(){
        Type listaPruebaTerminadaType = new TypeToken<List<PruebaTerminada>>() {}.getType();
        return new Gson().fromJson(this.pruebas, listaPruebaTerminadaType);
    }

}
