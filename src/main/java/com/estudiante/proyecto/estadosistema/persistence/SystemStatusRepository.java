package com.estudiante.proyecto.estadosistema.persistence;

/**
 * Contrato del repositorio para acceder al estado del sistema.
 *
 * <p>Define la abstracción de la capa de persistencia siguiendo el patrón Repository.
 * Las implementaciones pueden variar (en memoria, base de datos, servicio externo)
 * sin afectar a las capas superiores.</p>
 *
 * <p>Implementación actual: {@link InMemorySystemStatusRepository}</p>
 *
 * @author Keila
 * @version 0.0.1-SNAPSHOT
 */
public interface SystemStatusRepository {

    /**
     * Obtiene el estado operativo actual del sistema.
     *
     * @return cadena de texto con el estado (ej. {@code "UP"}, {@code "DOWN"})
     */
    String getCurrentStatus();
}