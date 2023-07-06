package esgi.tartitexture.contract.domain.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class ContractClosedException extends RuntimeException {

    private ContractClosedException(String message) {
        super(message);
    }

    public static ContractClosedException closedId(int id) {
        return new ContractClosedException(String.format("Contract: %d is closed.", id));
    }
}
