package com.estudiante.proyecto.estadosistema.service;

import com.estudiante.proyecto.estadosistema.domain.SystemStatus;
import com.estudiante.proyecto.estadosistema.persistence.SystemStatusRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Implementación de {@link SystemStatusService} que agrega información del entorno
 * de Spring con el estado reportado por el repositorio.
 *
 * <p>En cada invocación de {@link #getSystemStatus()} se consultan:</p>
 * <ul>
 *   <li>Los perfiles activos de Spring mediante {@link Environment#getActiveProfiles()}</li>
 *   <li>El estado del sistema mediante {@link SystemStatusRepository#getCurrentStatus()}</li>
 *   <li>La marca de tiempo actual formateada en ISO-8601</li>
 * </ul>
 *
 * <p>La propiedad {@code app.description} puede configurarse en
 * {@code application-dev.properties} o {@code application-prod.properties}.
 * Si no está definida, se usa el valor predeterminado {@code "Sistema de Estado"}.</p>
 *
 * @author Keila
 * @version 0.0.1-SNAPSHOT
 * @see SystemStatusService
 * @see SystemStatusRepository
 */
@Service
public class SystemStatusServiceImpl implements SystemStatusService {

    private final SystemStatusRepository repository;
    private final Environment environment;

    /**
     * Descripción del entorno inyectada desde {@code application.properties}.
     * Valor predeterminado: {@code "Sistema de Estado"}.
     */
    @Value("${app.description:Sistema de Estado}")
    private String appDescription;

    /**
     * Construye el servicio con sus dependencias requeridas.
     *
     * @param repository  repositorio que provee el estado operativo del sistema
     * @param environment entorno de Spring que expone los perfiles activos
     */
    public SystemStatusServiceImpl(SystemStatusRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    /**
     * Construye y devuelve un {@link SystemStatus} con la información actual del sistema.
     *
     * <p>Si no hay perfiles activos de Spring, el campo {@code activeProfile}
     * se establece como {@code "default"}.</p>
     *
     * @return estado del sistema con perfil activo, descripción y timestamp actuales
     */
    @Override
    public SystemStatus getSystemStatus() {
        String[] profiles = environment.getActiveProfiles();
        String activeProfile = profiles.length > 0 ? profiles[0] : "default";
        String status = repository.getCurrentStatus();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return new SystemStatus(status, activeProfile, appDescription, timestamp);
    }
}
