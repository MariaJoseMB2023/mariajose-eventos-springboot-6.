package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.Pago;
import sv.edu.movil.mariajose.eventos.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class PagoService {
    private final PagoRepository repository;
    public List<Pago> listar() { return repository.findAll(); }
    public Pago obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pago no encontrado")); }
    public Pago crear(Pago datos) { datos.setId(null); return repository.save(datos); }
    public Pago actualizar(Long id, Pago datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { Pago existente=obtenerPorId(id); repository.delete(existente); }
}
