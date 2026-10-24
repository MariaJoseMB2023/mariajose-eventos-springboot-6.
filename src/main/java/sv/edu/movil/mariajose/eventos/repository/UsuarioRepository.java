package sv.edu.movil.mariajose.eventos.repository;

import sv.edu.movil.mariajose.eventos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndClaveAndActivoTrue(String correo, String clave);
}