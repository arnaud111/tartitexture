package esgi.tartitexture.signing.application.services;

import esgi.tartitexture.signing.application.port.in.command.CreateSigningCommand;
import esgi.tartitexture.signing.application.port.in.usecase.signing.CreateSigningUseCase;
import esgi.tartitexture.signing.application.port.out.signing.CreateSigningPort;
import esgi.tartitexture.signing.domain.model.SigningModel;

public class CreateSigningService implements CreateSigningUseCase {

    private final CreateSigningPort createSigningPort;

    public CreateSigningService(CreateSigningPort createSigningPort) {
        this.createSigningPort = createSigningPort;
    }

    @Override
    public void createSigning(CreateSigningCommand createSigningCommand) {

        SigningModel signingModel = new SigningModel(
                0,
                createSigningCommand.getUserId(),
                createSigningCommand.getContractId(),
                false
        );

        createSigningPort.save(signingModel);
    }
}
