package nutricion.hexagonal.dominio.interfaces;

import java.util.Optional;

import nutricion.hexagonal.dominio.clases.Usuario;

public interface UsuarioRepo {
    Optional<Usuario> buscarPorEmail(String email);
    void guardar(Usuario usuario);
}