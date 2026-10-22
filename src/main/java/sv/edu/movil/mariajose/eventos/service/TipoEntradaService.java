package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.TipoEntrada;
import sv.edu.movil.mariajose.eventos.repository.TipoEntradaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class TipoEntradaService {
    private final TipoEntradaRepository repository;
    public List<TipoEntrada> listar() { return repository.findAll(); }
    public TipoEntrada obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "TipoEntrada no encontrado")); }
    public TipoEntrada crear(TipoEntrada datos) { datos.setId(null); return repository.save(datos); }
    public TipoEntrada actualizar(Long id, TipoEntrada datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { TipoEntrada existente=obtenerPorId(id); repository.delete(existente); }
}
