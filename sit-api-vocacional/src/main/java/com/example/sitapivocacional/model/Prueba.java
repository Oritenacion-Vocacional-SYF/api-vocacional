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
import java.util.List;

@Entity
@Table(name="pruebas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prueba {
    @Id
    @Column(name="id_prueba", nullable = false)
    private String idPrueba;

    @Lob
    @Column(name="preguntas", nullable = false)
    @JsonIgnore
    private String preguntas;

    public List<PreguntaPrueba> getListaPreguntas(){
        Type listaPreguntaType = new TypeToken<List<PreguntaPrueba>>() {}.getType();
        return new Gson().fromJson(this.preguntas, listaPreguntaType);
    }
}
