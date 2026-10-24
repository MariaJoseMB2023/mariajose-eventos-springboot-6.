package sv.edu.movil.mariajose.eventos.dto;

public record LoginResponse(
        Long id,
        String nombre,
        String correo,
        String rol,
        String token
) {
}