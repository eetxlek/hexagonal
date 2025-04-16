package nutricion.hexagonal.dominio.interfaces;

public interface Auth {
    String authenticate(String email, String password);
    boolean validateToken(String token);
    String extractUserId(String token);
}

