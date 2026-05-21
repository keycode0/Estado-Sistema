package com.estudiante.proyecto.estadosistema.service;

import com.estudiante.proyecto.estadosistema.domain.SystemStatus;

/**
 * Contrato de la capa de servicio para obtener el estado del sistema.
 *
 * <p>Define la lógica de negocio relacionada con la consulta del estado.
 * La implementación recopila información del entorno de Spring (perfil activo,
 * descripción de la aplicación) y la combina con los datos del repositorio.</p>
 *
 * <p>Implementación actual: {@link SystemStatusServiceImpl}</p>
 *
 * @author Keila
 * @version 0.0.1-SNAPSHOT
 */
public interface SystemStatusService {

    /**
     * Obtiene el estado completo del sistema en el momento de la llamada.
     *
     * @return objeto {@link SystemStatus} con estado, perfil activo,
     *         descripción del entorno y marca de tiempo actual
     */
    SystemStatus getSystemStatus();
}