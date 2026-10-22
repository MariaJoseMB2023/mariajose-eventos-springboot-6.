package sv.edu.movil.mariajose.eventos.controller;
import sv.edu.movil.mariajose.eventos.entity.Lugar;
import sv.edu.movil.mariajose.eventos.service.LugarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/lugares") @RequiredArgsConstructor @CrossOrigin(origins="*")
public class LugarController {
    private final LugarService service;
    @GetMapping public List<Lugar> listar() { return service.listar(); }
    @GetMapping("/{id}") public Lugar obtener(@PathVariable Long id) { return service.obtenerPorId(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Lugar crear(@RequestBody Lugar datos) { return service.crear(datos); }
    @PutMapping("/{id}") public Lugar actualizar(@PathVariable Long id,@RequestBody Lugar datos) { return service.actualizar(id,datos); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
