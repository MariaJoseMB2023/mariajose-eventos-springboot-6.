package sv.edu.movil.mariajose.eventos.repository;
import sv.edu.movil.mariajose.eventos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}
