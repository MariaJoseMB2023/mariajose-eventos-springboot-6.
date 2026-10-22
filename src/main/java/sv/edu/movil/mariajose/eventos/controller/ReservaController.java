package sv.edu.movil.mariajose.eventos.controller;
import sv.edu.movil.mariajose.eventos.entity.Reserva;
import sv.edu.movil.mariajose.eventos.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/reservas") @RequiredArgsConstructor @CrossOrigin(origins="*")
public class ReservaController {
    private final ReservaService service;
    @GetMapping public List<Reserva> listar() { return service.listar(); }
    @GetMapping("/{id}") public Reserva obtener(@PathVariable Long id) { return service.obtenerPorId(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Reserva crear(@RequestBody Reserva datos) { return service.crear(datos); }
    @PutMapping("/{id}") public Reserva actualizar(@PathVariable Long id,@RequestBody Reserva datos) { return service.actualizar(id,datos); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
