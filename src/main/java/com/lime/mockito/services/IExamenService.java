package com.lime.mockito.services;

import com.lime.mockito.models.Examen;

public interface IExamenService {

    Examen findExamByName(String nombre);

    Examen findExamByNameWithAnswer(String nombre);

    Examen guardar(Examen examen);
}
