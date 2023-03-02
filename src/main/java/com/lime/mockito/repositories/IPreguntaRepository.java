package com.lime.mockito.repositories;

import java.util.List;

public interface IPreguntaRepository {

    List<String> findPreguntasById(Long id);

    void guardarVarias(List<String> preguntas);
}
