package sv.edu.movil.mariajose.eventos.service;
import sv.edu.movil.mariajose.eventos.entity.Usuario;
import sv.edu.movil.mariajose.eventos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service @RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;
    public List<Usuario> listar() { return repository.findAll(); }
    public Usuario obtenerPorId(Long id) { return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado")); }
    public Usuario crear(Usuario datos) { datos.setId(null); return repository.save(datos); }
    public Usuario actualizar(Long id, Usuario datos) { obtenerPorId(id); datos.setId(id); return repository.save(datos); }
    public void eliminar(Long id) { Usuario existente=obtenerPorId(id); repository.delete(existente); }
}
