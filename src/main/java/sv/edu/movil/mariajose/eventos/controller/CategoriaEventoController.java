package sv.edu.movil.mariajose.eventos.controller;
import sv.edu.movil.mariajose.eventos.entity.CategoriaEvento;
import sv.edu.movil.mariajose.eventos.service.CategoriaEventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/categorias-evento") @RequiredArgsConstructor @CrossOrigin(origins="*")
public class CategoriaEventoController {
    private final CategoriaEventoService service;
    @GetMapping public List<CategoriaEvento> listar() { return service.listar(); }
    @GetMapping("/{id}") public CategoriaEvento obtener(@PathVariable Long id) { return service.obtenerPorId(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public CategoriaEvento crear(@RequestBody CategoriaEvento datos) { return service.crear(datos); }
    @PutMapping("/{id}") public CategoriaEvento actualizar(@PathVariable Long id,@RequestBody CategoriaEvento datos) { return service.actualizar(id,datos); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
