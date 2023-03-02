package com.lime.junit5.entity;

import com.lime.junit5.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    Cuenta cuenta;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Iniciando el TEST");
    }

    @BeforeEach
    void setUp() {
        cuenta = new Cuenta("David", new BigDecimal(2000));
        System.out.println("inicia el metodo");
    }

    @Test
    @Disabled // omite este test
    @DisplayName("Test de nombre")
    void testNombreCuenta() {
        cuenta.setPersona("David");
        fail(); // hace fallar el ejemplo
        assertEquals("David",cuenta.getPersona());
    }

    @Test
    void SaldoCuentaTest() {
        assertEquals(2000, cuenta.getSaldo().doubleValue());
    }

    @Test
    void CuentaTest() {
        Cuenta cuenta2 = new Cuenta("David", new BigDecimal(2000));
        assertEquals(cuenta2, cuenta);
    }

    @Test
    void CuentaDebitoTest() {
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1900, cuenta.getSaldo().doubleValue());
    }

    @Test
    void CuentaCreditoTest() {
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(2100, cuenta.getSaldo().doubleValue());

    }

    @Test
    void DineroInsuficienteExceptionTest() {
        Exception e = assertThrows(DineroInsuficienteException.class,() -> {
            cuenta.debito(new BigDecimal(2500));
        });
        String exception = e.getMessage();
    }

    @Test
    void TransferirTest() {
        Cuenta cuenta2 = new Cuenta("Andres", new BigDecimal(1500));
        Banco banco = new Banco("BBVA");

        banco.transferir(cuenta2, cuenta, new BigDecimal(100));

        assertAll(
                ()->assertEquals("1400", cuenta2.getSaldo().toPlainString()),
                ()-> assertEquals("2100", cuenta.getSaldo().toPlainString())
        );

    }

    @AfterEach
    void tearDown() {
        System.out.println("finaliza el metodo");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el TEST");
    }
}