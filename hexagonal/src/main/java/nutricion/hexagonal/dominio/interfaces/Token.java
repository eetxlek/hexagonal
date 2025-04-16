package nutricion.hexagonal.dominio.interfaces;

// Dominio: interfaz (puerto de salida)
public interface Token {
    String generarToken(String userId);  // ¿Qué necesitas?
    boolean validarToken(String token);  // ¿Qué necesitas?
    String extraerUserId(String token);   // ¿Qué necesitas?
}

