
package sv.edu.movil.mariajose.eventos.controller;

import sv.edu.movil.mariajose.eventos.entity.Evento;
import sv.edu.movil.mariajose.eventos.service.EventoService;
import sv.edu.movil.mariajose.eventos.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EventoController {

    private final EventoService service;
    private final TokenService tokenService;

    @GetMapping
    public List<Evento> listar() {
        return service.listar();
    }

    @GetMapping("/autenticado")
    public List<Evento> listarAutenticado(
            @RequestHeader(value = "Authorization", required = false) String authorization) {
        tokenService.validar(authorization);
        return service.listar();
    }

    @GetMapping("/{id}")
    public Evento obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento crear(@RequestBody Evento datos) {
        return service.crear(datos);
    }

    @PutMapping("/{id}")
    public Evento actualizar(
            @PathVariable Long id,
            @RequestBody Evento datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
