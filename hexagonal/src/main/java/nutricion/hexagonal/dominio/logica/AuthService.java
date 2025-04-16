package nutricion.hexagonal.dominio.logica;

import org.springframework.stereotype.Service;

import nutricion.hexagonal.dominio.clases.Usuario;
import nutricion.hexagonal.dominio.interfaces.PasswordEncrypter;
import nutricion.hexagonal.dominio.interfaces.UsuarioRepo;

@Service
public class AuthService {
    private final TokenService tokenService; // <- Depende de la interfaz
    private final UsuarioRepo usuarioRepository;
    private final PasswordEncrypter passwordEncrypter;

    public AuthService(TokenService tokenService, UsuarioRepo usuarioRepository, PasswordEncrypter passwordEncrypter) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncrypter = passwordEncrypter;
    }

    public String login(String email, String password) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncrypter.matches(password, usuario.getContraseña())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        return tokenService.generarToken(String.valueOf(usuario.getIdUsuario()));
    }

}
