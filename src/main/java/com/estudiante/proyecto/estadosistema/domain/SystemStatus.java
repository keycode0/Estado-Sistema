package com.estudiante.proyecto.estadosistema.domain;

/**
 * Modelo de dominio que representa el estado actual del sistema.
 *
 * <p>Esta clase es inmutable: todos sus campos se asignan en el constructor
 * y no posee setters. Se serializa automáticamente a JSON por Spring MVC
 * al ser devuelta desde el controlador REST.</p>
 *
 * <p>Ejemplo de respuesta JSON:</p>
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
 */
public class SystemStatus {

    /** Estado operativo del sistema (ej. "UP"). */
    private final String status;

    /** Perfil de Spring activo en tiempo de ejecución (ej. "dev", "prod", "default"). */
    private final String activeProfile;

    /** Descripción del entorno, configurable mediante {@code app.description}. */
    private final String description;

    /** Marca de tiempo de la consulta en formato ISO-8601 (ej. "2026-05-21T10:30:00"). */
    private final String timestamp;

    /**
     * Construye un nuevo {@code SystemStatus} con todos sus campos.
     *
     * @param status        estado operativo del sistema
     * @param activeProfile perfil de Spring activo
     * @param description   descripción del entorno de ejecución
     * @param timestamp     fecha y hora de la consulta en formato ISO-8601
     */
    public SystemStatus(String status, String activeProfile, String description, String timestamp) {
        this.status = status;
        this.activeProfile = activeProfile;
        this.description = description;
        this.timestamp = timestamp;
    }

    /**
     * Devuelve el estado operativo del sistema.
     *
     * @return estado del sistema (ej. "UP")
     */
    public String getStatus() { return status; }

    /**
     * Devuelve el perfil de Spring activo en tiempo de ejecución.
     *
     * @return nombre del perfil activo (ej. "dev", "prod")
     */
    public String getActiveProfile() { return activeProfile; }

    /**
     * Devuelve la descripción del entorno de ejecución.
     *
     * @return descripción configurada en las propiedades de la aplicación
     */
    public String getDescription() { return description; }

    /**
     * Devuelve la marca de tiempo de la consulta.
     *
     * @return fecha y hora en formato ISO-8601
     */
    public String getTimestamp() { return timestamp; }
}