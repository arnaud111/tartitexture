package esgi.tartitexture.contract.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContractException extends RuntimeException {

    private ContractException(String message) {
        super(message);
    }

    public static ContractException notFoundUserId(int id) {
        return new ContractException(String.format("Contract: %d not found.", id));
    }
}
