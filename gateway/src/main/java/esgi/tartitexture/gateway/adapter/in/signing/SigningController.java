package esgi.tartitexture.gateway.adapter.in.signing;

import esgi.tartitexture.gateway.adapter.in.signing.request.CreateSigningRequest;
import esgi.tartitexture.gateway.adapter.in.signing.response.SigningResponse;
import esgi.tartitexture.gateway.adapter.out.SigningPersistenceAdapter;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signing")
public class SigningController {

    private final SigningPersistenceAdapter signingPersistenceAdapter;

    public SigningController(SigningPersistenceAdapter signingPersistenceAdapter) {
        this.signingPersistenceAdapter = signingPersistenceAdapter;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public SigningResponse[] getAll() {
        return signingPersistenceAdapter.findAll();
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SigningResponse[] getSigningsByUserId(@PathVariable("id") int id) {
        return signingPersistenceAdapter.findAllForUser(id);
    }

    @GetMapping(value = "/contract/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SigningResponse[] getSigningsByContractId(@PathVariable("id") int id) {
        return signingPersistenceAdapter.findAllForContract(id);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SigningResponse getById(@PathVariable("id") int id) {
        return signingPersistenceAdapter.findById(id);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createSigning(@RequestBody @Valid CreateSigningRequest createSigningRequest) {
        signingPersistenceAdapter.create(createSigningRequest);
    }

    @PatchMapping(value = "/{id}")
    public void sign(@PathVariable("id") int id) {
        signingPersistenceAdapter.sign(id);
    }
}
