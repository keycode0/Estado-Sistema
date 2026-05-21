# EstadoSistema

Microservicio REST desarrollado con **Spring Boot 4.0.6** y **Java 21** que expone un endpoint de salud para monitorear el estado de la aplicación.

Proyecto académico — Universidad ESPE, 7mo Semestre, Programación Avanzada.

---

## Tecnologías

| Tecnología       | Versión  |
|------------------|----------|
| Java             | 21       |
| Spring Boot      | 4.0.6    |
| Gradle           | 9.4.1    |
| JUnit Jupiter    | 5.x      |

---

## Arquitectura

El proyecto sigue una arquitectura en capas:

```
com.estudiante.proyecto.estadosistema
├── domain/          → Modelo de datos (SystemStatus)
├── persistence/     → Acceso a datos (repositorio en memoria)
├── service/         → Lógica de negocio
└── web/controller/  → Endpoints REST
```

---

## Endpoint

### `GET /api/v1/health`

Devuelve el estado actual del sistema.

**Respuesta exitosa — HTTP 200:**

```json
{
  "status": "UP",
  "activeProfile": "dev",
  "description": "Entorno de Desarrollo",
  "timestamp": "2026-05-21T10:30:00"
}
```

| Campo           | Descripción                                      |
|-----------------|--------------------------------------------------|
| `status`        | Estado operativo del sistema (`UP`)              |
| `activeProfile` | Perfil de Spring activo (`dev`, `prod`)          |
| `description`   | Descripción del entorno configurada en properties|
| `timestamp`     | Fecha y hora de la consulta en formato ISO-8601  |

---

## Perfiles y Puertos

| Perfil | Puerto | Log Level      |
|--------|--------|----------------|
| `dev`  | 8080   | DEBUG          |
| `prod` | 9090   | WARN / INFO    |

El perfil activo se configura en `application.properties`:

```properties
spring.profiles.active=dev
```

---

## Ejecutar el proyecto

### Con Gradle Wrapper

```bash
# Windows
gradlew.bat bootRun

# Linux / macOS
./gradlew bootRun
```

### Con perfil específico

```bash
gradlew.bat bootRun --args='--spring.profiles.active=prod'
```

### Probar el endpoint

```bash
# Perfil dev (puerto 8080)
curl http://localhost:8080/api/v1/health

# Perfil prod (puerto 9090)
curl http://localhost:9090/api/v1/health
```

---

## Ejecutar pruebas

```bash
gradlew.bat test
```

---

## Estructura de archivos de configuración

```
src/main/resources/
├── application.properties        → Configuración base (perfil activo, context-path)
├── application-dev.properties    → Configuración de desarrollo (puerto 8080, DEBUG)
└── application-prod.properties   → Configuración de producción (puerto 9090, WARN)
```

---

## Extensibilidad

Para conectar una base de datos real, basta con:

1. Agregar la dependencia de Spring Data JPA en `build.gradle`.
2. Crear una nueva implementación de `SystemStatusRepository` con `@Repository`.
3. Configurar las propiedades de conexión en el profile correspondiente.

La capa de servicio no requiere cambios gracias al patrón Repository.