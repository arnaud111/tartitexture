package esgi.tartitexture.contract.adapter.in.controller;

import esgi.tartitexture.contract.adapter.in.controller.request.CreateContractRequest;
import esgi.tartitexture.contract.adapter.in.controller.request.UpdateContractRequest;
import esgi.tartitexture.contract.adapter.in.controller.response.ContractResponse;
import esgi.tartitexture.contract.adapter.in.mapper.ContractApiMapper;
import esgi.tartitexture.contract.application.port.in.command.CreateContractCommand;
import esgi.tartitexture.contract.application.port.in.command.UpdateContractCommand;
import esgi.tartitexture.contract.application.port.in.usecase.CreateContractUseCase;
import esgi.tartitexture.contract.application.port.in.usecase.FindContractUseCase;
import esgi.tartitexture.contract.application.port.in.usecase.UpdateContractUseCase;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractController {

    private final CreateContractUseCase createContractUseCase;
    private final FindContractUseCase findContractUseCase;
    private final UpdateContractUseCase updateContractUseCase;

    public ContractController(CreateContractUseCase createContractUseCase, FindContractUseCase findContractUseCase, UpdateContractUseCase updateContractUseCase) {
        this.createContractUseCase = createContractUseCase;
        this.findContractUseCase = findContractUseCase;
        this.updateContractUseCase = updateContractUseCase;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContractResponse> getAll() {
        return ContractApiMapper.listContractModelToListContractResponse(findContractUseCase.findAllContracts());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractResponse getById(@PathVariable("id") int id) {
        return ContractApiMapper.contractModelToContractResponse(findContractUseCase.findContract(id));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createContract(@RequestBody @Valid CreateContractRequest createContractRequest) {

        CreateContractCommand createContractCommand = new CreateContractCommand(
                createContractRequest.getName(),
                createContractRequest.getEndDate()
        );

        createContractUseCase.createContract(createContractCommand);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateContract(@PathVariable("id") int id, @RequestBody @Valid UpdateContractRequest updateContractRequest) {

        UpdateContractCommand updateContractCommand = new UpdateContractCommand(
                id,
                updateContractRequest.getName(),
                updateContractRequest.getEndDate(),
                updateContractRequest.isActivated(),
                updateContractRequest.isClosed()
        );

        updateContractUseCase.update(updateContractCommand);
    }
}
