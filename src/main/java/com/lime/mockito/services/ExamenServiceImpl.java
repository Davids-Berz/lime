package com.lime.mockito.services;

import com.lime.mockito.models.Examen;
import com.lime.mockito.repositories.IExamenRepository;
import com.lime.mockito.repositories.IPreguntaRepository;

import java.util.List;

public class ExamenServiceImpl implements IExamenService {

    public ExamenServiceImpl(IExamenRepository examenRepository, IPreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }
    private IPreguntaRepository preguntaRepository;
    private IExamenRepository examenRepository;

    @Override
    public Examen findExamByName(String nombre) {
        return examenRepository
                .findAll()
                .stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst().orElse(null);
    }

    @Override
    public Examen findExamByNameWithAnswer(String nombre) {
        Examen e = findExamByName(nombre);
        if (e != null) {
            List<String> preguntas = preguntaRepository.findPreguntasById(e.getId());
            e.setPreguntas(preguntas);
        }
        return e;
    }

    @Override
    public Examen guardar(Examen examen) {
        if (!examen.getPreguntas().isEmpty()) {
            preguntaRepository.guardarVarias(examen.getPreguntas());
        }
        return examenRepository.guardar(examen);
    }

}
