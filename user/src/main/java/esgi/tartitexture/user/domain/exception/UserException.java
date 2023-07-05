package esgi.tartitexture.user.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException {

    private UserException(String message) {
        super(message);
    }

    public static UserException notFoundUserId(int id) {
        return new UserException(String.format("User: %d not found.", id));
    }
}
