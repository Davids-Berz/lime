package com.lime.junit5.entity;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.Properties;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class UsuarioTest {

    static boolean isDev;
    @BeforeAll
    static void beforeAll() {
        System.setProperty("ENV", "dev");
        isDev = "dev".equalsIgnoreCase(System.getProperty("ENV"));
    }

    // condicionales

    @Test
    @Disabled
    void name() {

        Usuario usuario = new Usuario("David");
        assertEquals("Davids", usuario.getName());

    }

    @Test
    @Disabled
    @EnabledOnOs(OS.MAC)
    void testW() {
        Usuario usuario = new Usuario("David");
        assertEquals("David", usuario.getName());
    }

    @Test
    @Disabled
    void names() {

        Usuario usuario = new Usuario("David");
        assertEquals("David", usuario.getName());

    }

    @Test
    @Disabled
    @DisabledOnOs(OS.WINDOWS)
    void testNoW() {
        Usuario usuario = new Usuario("David");
        assertEquals("David", usuario.getName());
    }

    @Test
    @Disabled
    @EnabledOnJre(JRE.JAVA_8)
    void testJDK8() {
        Usuario usuario = new Usuario("David");
        assertEquals("David", usuario.getName());
    }

    @Test
    @Disabled
    @EnabledOnJre(JRE.JAVA_18)
    void testJDK18() {
        Usuario usuario = new Usuario("David");
        assertEquals("David", usuario.getName());
    }

    @Test
    @Disabled
    void propiedadesDeSistema() {
        Properties p = System.getProperties();
        p.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    @Test
    @Disabled
    @EnabledIfSystemProperty(named = "java.version", matches = "18")
    void javaVersionTest() {
        System.out.println("version de java 18");
    }

    @Test
    @Disabled
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void envTest() {
        System.out.println("");
    }

    @Test
    @Disabled
    @Tag("dev")
    void devTest() {
        Assumptions.assumeTrue(isDev);
        System.out.println("Entorno de desarrollo");
    }

    @Test
    @Disabled
    @Timeout(5)
    @Tag("timeout")
    void tiempoEsperaTest() throws InterruptedException {
        TimeUnit.SECONDS.sleep(6);
    }

    @Test
    @Disabled
    void tiempoEsperaAssertTest() {
        assertTimeout(Duration.ofSeconds(2),()-> {
            TimeUnit.SECONDS.sleep(3);
        });
    }

}