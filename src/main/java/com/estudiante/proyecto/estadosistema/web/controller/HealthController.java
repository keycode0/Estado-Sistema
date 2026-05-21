package com.estudiante.proyecto.estadosistema.web.controller;

import com.estudiante.proyecto.estadosistema.domain.SystemStatus;
import com.estudiante.proyecto.estadosistema.service.SystemStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST que expone el endpoint de salud del sistema.
 *
 * <p>Todos los endpoints de este controlador se sirven bajo el contexto
 * {@code /api/v1} definido en {@code application.properties}
 * ({@code server.servlet.context-path}).</p>
 *
 * <p>Endpoint disponible:</p>
 * <ul>
 *   <li>{@code GET /api/v1/health} — devuelve el estado actual del sistema en JSON</li>
 * </ul>
 *
 * <p>Ejemplo de respuesta exitosa (HTTP 200):</p>
 * <pre>{@code
 * {
 *   "status": "UP",
 *   "activeProfile": "dev",
 *   "description": "Entorno de Desarrollo",
 *   "timestamp": "2026-05-21T10:30:00"
 * }
 * }</pre>
 *
 * @author Keila
 * @version 0.0.1-SNAPSHOT
 * @see SystemStatusService
 * @see SystemStatus
 */
@RestController
public class HealthController {

    private final SystemStatusService systemStatusService;

    /**
     * Construye el controlador con el servicio de estado del sistema.
     *
     * @param systemStatusService servicio que provee la información de salud del sistema
     */
    public HealthController(SystemStatusService systemStatusService) {
        this.systemStatusService = systemStatusService;
    }

    /**
     * Retorna el estado actual del sistema.
     *
     * <p>Mapea solicitudes {@code GET} al path {@code /health} (relativo al
     * context-path configurado). Delega la lógica al {@link SystemStatusService}
     * y envuelve el resultado en una respuesta HTTP 200.</p>
     *
     * @return {@link ResponseEntity} con código 200 OK y el cuerpo {@link SystemStatus}
     *         serializado como JSON
     */
    @GetMapping("/health")
    public ResponseEntity<SystemStatus> health() {
        return ResponseEntity.ok(systemStatusService.getSystemStatus());
    }
}