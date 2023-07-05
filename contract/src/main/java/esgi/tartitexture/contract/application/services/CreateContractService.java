package esgi.tartitexture.contract.application.services;

import esgi.tartitexture.contract.application.port.in.command.CreateContractCommand;
import esgi.tartitexture.contract.application.port.in.usecase.CreateContractUseCase;
import esgi.tartitexture.contract.application.port.out.CreateContractPort;
import esgi.tartitexture.contract.domain.model.ContractModel;

public class CreateContractService implements CreateContractUseCase {

    private final CreateContractPort createContractPort;

    public CreateContractService(CreateContractPort createContractPort) {
        this.createContractPort = createContractPort;
    }

    @Override
    public void createContract(CreateContractCommand createContractCommand) {

        ContractModel contractModel = new ContractModel(
                0,
                createContractCommand.getName(),
                createContractCommand.getEndDate(),
                true,
                false
        );

        createContractPort.save(contractModel);
    }
}
