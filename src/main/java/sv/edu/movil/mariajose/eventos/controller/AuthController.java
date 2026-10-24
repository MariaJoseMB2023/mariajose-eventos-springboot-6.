package sv.edu.movil.mariajose.eventos.controller;

import sv.edu.movil.mariajose.eventos.dto.LoginRequest;
import sv.edu.movil.mariajose.eventos.dto.LoginResponse;
import sv.edu.movil.mariajose.eventos.entity.Usuario;
import sv.edu.movil.mariajose.eventos.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        Usuario usuario = usuarioRepository
                .findByCorreoAndClaveAndActivoTrue(
                        request.correo(), request.clave())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Credenciales incorrectas"));

        String token = "TOKEN-" + usuario.getId();

        return new LoginResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getRol(),
                token
        );
    }
}