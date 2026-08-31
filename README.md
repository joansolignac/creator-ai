<p align="center">
  <img src="https://img.icons8.com/color/1200/spring-logo.jpg" alt="Logo de Spring Boot" width="110" />
  &nbsp;&nbsp;
  <strong style="font-size: 2.4em; vertical-align: middle;">Spring Boot</strong>
</p>

<h1 align="center">Creator AI</h1>

Backend para una plataforma de creadores que emplea modelos de inteligencia artificial para generar bocetos estructurados de cursos. El objetivo es acompañar el flujo de definición de un curso desde el tema inicial hasta la selección de un resultado generado.

## Estado actual

El proyecto se encuentra en una etapa inicial de construcción del backend. Actualmente incluye:

- Integración con Spring AI y un registro de proveedores de IA; DeepSeek es el proveedor configurado actualmente.
- Endpoints para seleccionar un proveedor y comprobar la disponibilidad del modelo activo.
- Módulo de chats persistido con JPA y MySQL: crear, listar por usuario con paginación, editar el título y eliminar chats.
- Estados de flujo para el chat: espera de tema, espera de respuestas, selección de título y finalización.
- Auditoría de entidades con identificadores UUID y fechas de creación y actualización.

La generación de bocetos de cursos y el flujo conversacional completo aún no están implementados.

## Tecnologías

- Java 25
- Spring Boot 4
- Spring AI 2
- Spring Data JPA
- MySQL
- Gradle

## Ejecutar localmente

1. Inicia MySQL con Docker Compose:

   ```powershell
   docker compose up -d db
   ```

2. Configura las variables de entorno requeridas:

   ```text
   DB_HOST=localhost
   DB_PORT=3306
   DB_NAME=creator_ai_db
   DB_USERNAME=root
   DB_PASSWORD=root
   DEEPSEEK_API_KEY=...
   DEEPSEEK_BASE_URL=...
   DEEPSEEK_MODEL=...
   ```

3. Ejecuta la aplicación:

   ```powershell
   .\gradlew.bat bootRun
   ```

El servicio queda disponible en `http://localhost:8080/api/v1`.

## API disponible

| Método | Ruta | Descripción |
| --- | --- | --- |
| `POST` | `/chats` | Crea un chat para un usuario. |
| `GET` | `/chats/users/{userId}?page=0&size=10` | Lista los chats de un usuario. |
| `PATCH` | `/chats/{chatId}` | Actualiza el título de un chat. |
| `DELETE` | `/chats/{chatId}` | Elimina un chat. |
| `POST` | `/ai/provider` | Selecciona el proveedor de IA. |
| `GET` | `/ai/provider/status` | Consulta la disponibilidad del proveedor activo. |

## Pruebas

```powershell
.\gradlew.bat test
```
