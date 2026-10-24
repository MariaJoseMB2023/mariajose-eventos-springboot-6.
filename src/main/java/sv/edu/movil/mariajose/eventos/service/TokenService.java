
package sv.edu.movil.mariajose.eventos.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TokenService {

    public void validar(String authorization) {
        if (authorization == null ||
                !authorization.startsWith("Bearer TOKEN-")) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Token no válido");
        }
    }
}