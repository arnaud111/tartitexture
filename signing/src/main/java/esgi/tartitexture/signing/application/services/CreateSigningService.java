package esgi.tartitexture.signing.application.services;

import esgi.tartitexture.signing.application.port.in.command.CreateSigningCommand;
import esgi.tartitexture.signing.application.port.in.usecase.signing.CreateSigningUseCase;
import esgi.tartitexture.signing.application.port.out.contract.FindContractPort;
import esgi.tartitexture.signing.application.port.out.signing.CreateSigningPort;
import esgi.tartitexture.signing.application.port.out.user.FindUserPort;
import esgi.tartitexture.signing.domain.exception.ContractClosedException;
import esgi.tartitexture.signing.domain.model.ContractModel;
import esgi.tartitexture.signing.domain.model.SigningModel;
import esgi.tartitexture.signing.domain.model.UserModel;

public class CreateSigningService implements CreateSigningUseCase {

    private final CreateSigningPort createSigningPort;
    private final FindContractPort findContractPort;
    private final FindUserPort findUserPort;

    public CreateSigningService(CreateSigningPort createSigningPort, FindContractPort findContractPort, FindUserPort findUserPort) {
        this.createSigningPort = createSigningPort;
        this.findContractPort = findContractPort;
        this.findUserPort = findUserPort;
    }

    @Override
    public void createSigning(CreateSigningCommand createSigningCommand) {

        UserModel userModel = findUserPort.findUserById(createSigningCommand.getUserId());
        ContractModel contractModel = findContractPort.findContractById(createSigningCommand.getContractId());

        if (contractModel.isClosed()) throw ContractClosedException.closedContractId(contractModel.getId());

        SigningModel signingModel = new SigningModel(
                0,
                createSigningCommand.getUserId(),
                createSigningCommand.getContractId(),
                false
        );

        createSigningPort.save(signingModel);
    }
}
