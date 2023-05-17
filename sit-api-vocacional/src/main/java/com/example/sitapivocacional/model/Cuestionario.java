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
@Table(name="cuestionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cuestionario {
    @Id
    @Column(name="id_cuestionario", nullable = false)
    private String idCuestionario;

    @Lob
    @Column(name="preguntas", nullable = false)
    @JsonIgnore
    private String preguntas;

    public List<PreguntaCuestionario> getListaPreguntas(){
        Type listaPreguntaType = new TypeToken<List<PreguntaCuestionario>>() {}.getType();
        return new Gson().fromJson(this.preguntas, listaPreguntaType);
    }
}
