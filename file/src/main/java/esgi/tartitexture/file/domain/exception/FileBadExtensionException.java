package esgi.tartitexture.file.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FileBadExtensionException extends RuntimeException {

    public FileBadExtensionException(String message) {
        super(message);
    }

}
