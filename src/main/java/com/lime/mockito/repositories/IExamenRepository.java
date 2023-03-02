package com.lime.mockito.repositories;

import com.lime.mockito.models.Examen;

import java.util.List;

public interface IExamenRepository {

    List<Examen> findAll();

    Examen guardar(Examen examen);
}
