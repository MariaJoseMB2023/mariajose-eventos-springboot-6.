package sv.edu.movil.mariajose.eventos.controller;
import sv.edu.movil.mariajose.eventos.entity.TipoEntrada;
import sv.edu.movil.mariajose.eventos.service.TipoEntradaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/tipos-entrada") @RequiredArgsConstructor @CrossOrigin(origins="*")
public class TipoEntradaController {
    private final TipoEntradaService service;
    @GetMapping public List<TipoEntrada> listar() { return service.listar(); }
    @GetMapping("/{id}") public TipoEntrada obtener(@PathVariable Long id) { return service.obtenerPorId(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public TipoEntrada crear(@RequestBody TipoEntrada datos) { return service.crear(datos); }
    @PutMapping("/{id}") public TipoEntrada actualizar(@PathVariable Long id,@RequestBody TipoEntrada datos) { return service.actualizar(id,datos); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
