package sv.edu.movil.mariajose.eventos.repository;
import sv.edu.movil.mariajose.eventos.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventoRepository extends JpaRepository<Evento, Long> {}
