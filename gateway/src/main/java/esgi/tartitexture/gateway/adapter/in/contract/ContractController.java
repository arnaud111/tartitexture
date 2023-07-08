package esgi.tartitexture.gateway.adapter.in.contract;

import esgi.tartitexture.gateway.adapter.in.contract.request.CreateContractRequest;
import esgi.tartitexture.gateway.adapter.in.contract.request.UpdateContractRequest;
import esgi.tartitexture.gateway.adapter.in.contract.response.ContractResponse;
import esgi.tartitexture.gateway.adapter.out.ContractPersistenceAdapter;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private final ContractPersistenceAdapter contractPersistenceAdapter;

    public ContractController(ContractPersistenceAdapter contractPersistenceAdapter) {
        this.contractPersistenceAdapter = contractPersistenceAdapter;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractResponse getById(@PathVariable("id") int id) {
        return contractPersistenceAdapter.findContractById(id);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractResponse[] getAll() {
        return contractPersistenceAdapter.findAllContract();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createContract(@RequestBody @Valid CreateContractRequest createContractRequest) {
        contractPersistenceAdapter.create(createContractRequest);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateContract(@PathVariable("id") int id, @RequestBody @Valid UpdateContractRequest updateContractRequest) {
        contractPersistenceAdapter.update(updateContractRequest, id);
    }

    @PatchMapping(value = "/{id}/activate")
    public void activateContract(@PathVariable("id") int id) {
        contractPersistenceAdapter.activateContract(id);
    }

    @PatchMapping(value = "/{id}/deactivate")
    public void deactivateContract(@PathVariable("id") int id) {
        contractPersistenceAdapter.deactivateContract(id);
    }

    @PatchMapping(value = "/{id}/close")
    public void closeContract(@PathVariable("id") int id) {
        contractPersistenceAdapter.closeContract(id);
    }
}
