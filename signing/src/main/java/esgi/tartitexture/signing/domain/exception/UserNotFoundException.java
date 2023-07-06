package esgi.tartitexture.signing.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    private UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException notFoundUserId(int id) {
        return new UserNotFoundException(String.format("User: %d not found.", id));
    }
}
