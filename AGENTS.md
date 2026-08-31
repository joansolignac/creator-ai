# AGENTS.md

## Propósito

Creator AI es un backend para generar bocetos de cursos dirigidos a una plataforma de creadores. El proyecto está implementado con Java y Spring Boot, y separa sus capacidades por módulos.

## Estructura del código

- `common/`: configuración, excepciones, modelos y DTOs compartidos.
- `modules/ai/`: selección, disponibilidad y acceso al proveedor de IA.
- `modules/chat/`: ciclo de vida de los chats de generación de cursos.

## Convenciones

- Mantén los controladores finos; la lógica de negocio pertenece a servicios y los accesos reutilizables a helpers.
- Usa DTOs para solicitudes y respuestas HTTP. Valida solicitudes con Jakarta Validation.
- Usa nombres de identificadores con el patrón `<recurso>Id`; consulta `docs/naming-conventions.md` antes de introducir nuevos nombres o estados.
- Usa `UUID` para identificadores de entidades auditables y `int` para `userId` mientras el contrato de usuario mantenga ese tipo.
- Los endpoints viven bajo `/api/v1`, definido por `server.servlet.context-path`.

## Verificación

- Ejecuta `./gradlew.bat test` en Windows antes de entregar cambios de Java.
- No añadas secretos al repositorio. La configuración del proveedor y de MySQL se resuelve mediante variables de entorno.
- Conserva los cambios ajenos que ya existan en el árbol de trabajo; no los incluyas en un commit salvo que formen parte explícita de la tarea.
