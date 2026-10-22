package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.Cliente;
import sv.edu.movil.mariajose.eventos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;
    public List<Cliente> listar() { return repository.findAll(); }
    public Cliente obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado")); }
    public Cliente crear(Cliente datos) { datos.setId(null); return repository.save(datos); }
    public Cliente actualizar(Long id, Cliente datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { Cliente existente=obtenerPorId(id); repository.delete(existente); }
}
