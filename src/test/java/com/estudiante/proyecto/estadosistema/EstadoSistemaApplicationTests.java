package com.estudiante.proyecto.estadosistema;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Pruebas de integración para {@link EstadoSistemaApplication}.
 *
 * <p>Verifica que el contexto de Spring se carga correctamente con todas
 * las dependencias inyectadas ({@code @Service}, {@code @Repository},
 * {@code @RestController}) sin errores de configuración.</p>
 *
 * @author Keila
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootTest
class EstadoSistemaApplicationTests {

    /**
     * Verifica que el contexto de aplicación de Spring se inicializa sin errores.
     *
     * <p>Si el contexto no puede arrancar (ej. beans mal configurados, propiedades
     * faltantes), este test fallará con una excepción descriptiva.</p>
     */
    @Test
    void contextLoads() {
    }

}