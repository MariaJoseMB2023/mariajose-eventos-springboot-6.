package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.CategoriaEvento;
import sv.edu.movil.mariajose.eventos.repository.CategoriaEventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class CategoriaEventoService {
    private final CategoriaEventoRepository repository;
    public List<CategoriaEvento> listar() { return repository.findAll(); }
    public CategoriaEvento obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CategoriaEvento no encontrado")); }
    public CategoriaEvento crear(CategoriaEvento datos) { datos.setId(null); return repository.save(datos); }
    public CategoriaEvento actualizar(Long id, CategoriaEvento datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { CategoriaEvento existente=obtenerPorId(id); repository.delete(existente); }
}
