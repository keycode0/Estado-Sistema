package com.estudiante.proyecto.estadosistema.persistence;

import org.springframework.stereotype.Repository;

/**
 * Implementación en memoria del repositorio de estado del sistema.
 *
 * <p>Esta implementación retorna un estado fijo {@code "UP"} sin persistencia
 * real en base de datos. Es útil para desarrollo, pruebas y entornos donde
 * no se requiere almacenamiento externo del estado.</p>
 *
 * <p>Para reemplazarla por una implementación con base de datos, basta con
 * crear una nueva clase que implemente {@link SystemStatusRepository} y
 * anotar la implementación deseada con {@code @Primary} o usar perfiles
 * de Spring para activarla condicionalmente.</p>
 *
 * @author Keila
 * @version 0.0.1-SNAPSHOT
 * @see SystemStatusRepository
 */
@Repository
public class InMemorySystemStatusRepository implements SystemStatusRepository {

    /**
     * Devuelve el estado actual del sistema.
     *
     * <p>En esta implementación el valor siempre es {@code "UP"}, simulando
     * que el sistema está operativo.</p>
     *
     * @return {@code "UP"} indicando que el sistema está en funcionamiento
     */
    @Override
    public String getCurrentStatus() {
        return "UP";
    }
}