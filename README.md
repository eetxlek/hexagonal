Este proyecto implementa una API REST segura utilizando:
✅ Arquitectura Hexagonal (Ports & Adapters)
✅ Spring Security + JWT para autenticación
✅ MySQL como base de datos
✅ Spring Data JPA para persistencia

Características Clave:
1. Dominio Aislado (Hexagonal)
Usuario.java: Entidad de negocio sin anotaciones JPA.

UsuarioRepository: Puerto (interfaz) para persistencia.

AuthService: Lógica de autenticación (registro, login).

2. Infraestructura
UsuarioRepositoryJpa: Adaptador de MySQL usando Spring Data JPA.

JwtTokenProvider: Generación/validación de tokens JWT.

UserPrincipalAdapter: Adapta Usuario → UserDetails para Spring Security.

3. Spring Security
Stateless JWT: Sin sesiones.

Endpoints protegidos:

/api/auth/**: Público (login/registro).

Resto que se implementarán: Requieren JWT.
