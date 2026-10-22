package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.Reserva;
import sv.edu.movil.mariajose.eventos.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository repository;
    public List<Reserva> listar() { return repository.findAll(); }
    public Reserva obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrado")); }
    public Reserva crear(Reserva datos) { datos.setId(null); return repository.save(datos); }
    public Reserva actualizar(Long id, Reserva datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { Reserva existente=obtenerPorId(id); repository.delete(existente); }
}
