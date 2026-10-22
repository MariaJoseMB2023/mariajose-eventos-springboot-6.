package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.Evento;
import sv.edu.movil.mariajose.eventos.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class EventoService {
    private final EventoRepository repository;
    public List<Evento> listar() { return repository.findAll(); }
    public Evento obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado")); }
    public Evento crear(Evento datos) { datos.setId(null); return repository.save(datos); }
    public Evento actualizar(Long id, Evento datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { Evento existente=obtenerPorId(id); repository.delete(existente); }
}
