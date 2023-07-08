package esgi.tartitexture.gateway.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SigningNotFoundException extends RuntimeException {

    private SigningNotFoundException(String message) {
        super(message);
    }

    public static SigningNotFoundException notFoundSigningId(int id) {
        return new SigningNotFoundException(String.format("Signing: %d not found.", id));
    }
}
