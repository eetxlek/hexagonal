package nutricion.hexagonal.infra.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


//consulta por email con Data JPA
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, String> {
    Optional<UsuarioEntity> findByEmail(String email);
}


