package com.lime.mockito.services;

import com.lime.mockito.models.Examen;
import com.lime.mockito.repositories.IExamenRepository;
import com.lime.mockito.repositories.IPreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

// opcion para usar injeccion de dependencias @ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {

    @Mock
    IExamenRepository repository;
    @Mock
    IPreguntaRepository preguntaRepository;
    @InjectMocks
    ExamenServiceImpl service;

    @Captor
    ArgumentCaptor<Long> capture;

    @BeforeEach
    void setUp() {
        // opcion para usar injeccion de dependencias
        // MockitoAnnotations.openMocks(this);
        /*this.repository = Mockito.mock(IExamenRepository.class);
        this.preguntaRepository = Mockito.mock(IPreguntaRepository.class);
        this.service = new ExamenServiceImpl(repository, preguntaRepository);*/
    }

    @Test
    void findExamByName() {

        Mockito
                .when(repository.findAll())
                .thenReturn(DataSource.EXAMENES);

        Examen examen = service.findExamByName("Fisica");
        assertNotNull(examen);
        assertEquals(3L, examen.getId());
        assertEquals("Fisica", examen.getNombre());


    }

    @Test
    void findExamByNameEmptyList() {
        List<Examen> data = Collections.EMPTY_LIST;
        Mockito
                .when(repository.findAll())
                .thenReturn(data);

        Examen examen = service.findExamByName("Fisica");
        assertNull(examen);

    }

    @Test
    void preguntaExamenTest() {
        Mockito
                .when(repository.findAll())
                .thenReturn(DataSource.EXAMENES);
        Mockito.when(preguntaRepository.findPreguntasById(ArgumentMatchers.anyLong()))
                .thenReturn(DataSource.PREGUNTAS);

        Examen examen = service.findExamByNameWithAnswer("Historia");
        assertEquals(5, examen.getPreguntas().size());
        Mockito.verify(repository).findAll();
        Mockito.verify(preguntaRepository).findPreguntasById(ArgumentMatchers.anyLong());
        Mockito.verify(preguntaRepository).findPreguntasById(capture.capture());
        assertEquals(1L, capture.getValue());


    }

    @Test
    void guardarExamentest() {
        //given
        AtomicInteger count = new AtomicInteger(3);
        Mockito.when(repository.guardar(ArgumentMatchers.any(Examen.class)))
                .then(invocationOnMock -> {
                    Long value = Long.valueOf(count.incrementAndGet());
                    Examen examen = invocationOnMock.getArgument(0);
                    examen.setId(value);
                    return examen;
                });
        //when
        Examen examen = repository.guardar(DataSource.EXAMEN);
        //then
        assertNotNull(examen.getId());
        assertEquals(4L, examen.getId());
        assertEquals("Quimica", examen.getNombre());
        Mockito.verify(repository).guardar(ArgumentMatchers.any(Examen.class));
//        Mockito.verify(preguntaRepository).guardarVarias(ArgumentMatchers.anyList());
    }

    @Test
    void ordenTest(){
        Mockito.when(repository.findAll()).thenReturn(DataSource.EXAMENES);
        service.findExamByNameWithAnswer("Fisica");
        service.findExamByNameWithAnswer("Historia");

        InOrder order = Mockito.inOrder(repository, preguntaRepository);
        order.verify(repository).findAll();
        order.verify(preguntaRepository).findPreguntasById(3L);
        order.verify(repository).findAll();
        order.verify(preguntaRepository).findPreguntasById(1L);
    }

    @Test
    void numeroInvocacion() {
        Mockito.when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);
        service.findExamByNameWithAnswer("Historia");
        Mockito.verify(preguntaRepository, Mockito.never()).findPreguntasById(1L);
        Mockito.verifyNoInteractions(preguntaRepository);
    }
}