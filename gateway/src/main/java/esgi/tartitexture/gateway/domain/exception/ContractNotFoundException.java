package esgi.tartitexture.gateway.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContractNotFoundException extends RuntimeException {

    private ContractNotFoundException(String message) {
        super(message);
    }

    public static ContractNotFoundException notFoundContractId(int id) {
        return new ContractNotFoundException(String.format("Contract: %d not found.", id));
    }
}
