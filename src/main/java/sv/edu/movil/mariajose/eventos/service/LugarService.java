package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.Lugar;
import sv.edu.movil.mariajose.eventos.repository.LugarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class LugarService {
    private final LugarRepository repository;
    public List<Lugar> listar() { return repository.findAll(); }
    public Lugar obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lugar no encontrado")); }
    public Lugar crear(Lugar datos) { datos.setId(null); return repository.save(datos); }
    public Lugar actualizar(Long id, Lugar datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { Lugar existente=obtenerPorId(id); repository.delete(existente); }
}
