package com.lime.mockito.services;

import com.lime.mockito.models.Examen;

import java.util.Arrays;
import java.util.List;

public class DataSource {

    public static final List<Examen> EXAMENES = Arrays.asList(
            new Examen(1L, "Historia"),
            new Examen(2L, "Mates"),
            new Examen(3L, "Fisica")
    );


    public final static List<String> PREGUNTAS = Arrays.asList("Aritmetica", "integrales", "trigonometria",
            "derivadas", "geometria");
    public static final Examen EXAMEN = new Examen(null,"Quimica");
}
