package com.lime.mockito.repositories;

import com.lime.mockito.models.Examen;

import java.util.Arrays;
import java.util.List;

public class ExamenRepositoryImpl implements IExamenRepository {
    @Override
    public List<Examen> findAll() {
        return Arrays.asList(
                new Examen(1L, "Historia"),
                new Examen(2L, "Mates"),
                new Examen(3L, "Fisica")
        );
    }

    @Override
    public Examen guardar(Examen examen) {
        return new Examen(4L,"Quimica");
    }
}
