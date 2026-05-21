package com.estudiante.proyecto.estadosistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación EstadoSistema.
 *
 * <p>Esta aplicación es un microservicio REST construido con Spring Boot que expone
 * un endpoint de salud ({@code /api/v1/health}) para monitorear el estado del sistema.
 * Reporta el estado actual, el perfil activo de Spring (dev/prod) y la marca de tiempo
 * de la consulta.</p>
 *
 * <p>Arquitectura en capas:</p>
 * <ul>
 *   <li><b>Domain</b>: Modelo de datos {@code SystemStatus}</li>
 *   <li><b>Persistence</b>: Repositorio en memoria {@code InMemorySystemStatusRepository}</li>
 *   <li><b>Service</b>: Lógica de negocio {@code SystemStatusServiceImpl}</li>
 *   <li><b>Web</b>: Controlador REST {@code HealthController}</li>
 * </ul>
 *
 * @author Keila
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class EstadoSistemaApplication {

    /**
     * Punto de entrada de la aplicación Spring Boot.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        SpringApplication.run(EstadoSistemaApplication.class, args);
    }

}