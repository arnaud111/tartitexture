package esgi.tartitexture.signing.adapter.in.controller;

import esgi.tartitexture.signing.adapter.in.controller.request.CreateSigningRequest;
import esgi.tartitexture.signing.adapter.in.controller.response.SigningResponse;
import esgi.tartitexture.signing.adapter.in.mapper.SigningApiMapper;
import esgi.tartitexture.signing.application.port.in.command.CreateSigningCommand;
import esgi.tartitexture.signing.application.port.in.usecase.CreateSigningUseCase;
import esgi.tartitexture.signing.application.port.in.usecase.FindSigningUseCase;
import esgi.tartitexture.signing.application.port.in.usecase.UpdateSigningUseCase;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signing")
public class SigningController {

    private final CreateSigningUseCase createSigningUseCase;
    private final FindSigningUseCase findSigningUseCase;
    private final UpdateSigningUseCase updateSigningUseCase;

    public SigningController(CreateSigningUseCase createSigningUseCase, FindSigningUseCase findSigningUseCase, UpdateSigningUseCase updateSigningUseCase) {
        this.createSigningUseCase = createSigningUseCase;
        this.findSigningUseCase = findSigningUseCase;
        this.updateSigningUseCase = updateSigningUseCase;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SigningResponse> getAll() {
        return SigningApiMapper.listSigningModelToListSingingResponse(findSigningUseCase.findAllSignings());
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SigningResponse> getSigningsByUserId(@PathVariable("id") int id) {
        return SigningApiMapper.listSigningModelToListSingingResponse(findSigningUseCase.findSigningsByUserId(id));
    }

    @GetMapping(value = "/contract/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SigningResponse> getSigningsByContractId(@PathVariable("id") int id) {
        return SigningApiMapper.listSigningModelToListSingingResponse(findSigningUseCase.findSigningsByContractId(id));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SigningResponse getById(@PathVariable("id") int id) {
        return SigningApiMapper.signingModelToSigningResponse(findSigningUseCase.findSigning(id));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createSigning(@RequestBody @Valid CreateSigningRequest createSigningRequest) {

        CreateSigningCommand createSigningCommand = new CreateSigningCommand(
                createSigningRequest.getUserId(),
                createSigningRequest.getContractId()
        );

        createSigningUseCase.createSigning(createSigningCommand);
    }

    @PatchMapping(value = "/{id}")
    public void sign(@PathVariable("id") int id) {
        updateSigningUseCase.sign(id);
    }
}
