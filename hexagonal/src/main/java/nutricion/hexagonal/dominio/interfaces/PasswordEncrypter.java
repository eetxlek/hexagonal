package nutricion.hexagonal.dominio.interfaces;

//buena practica como puerto
public interface PasswordEncrypter {
    boolean matches(String rawPassword, String hashedPassword);
}

