package esgi.tartitexture.contract.application.port.in.usecase;

import esgi.tartitexture.contract.application.port.in.command.CreateContractCommand;

public interface CreateContractUseCase {

    void createContract(CreateContractCommand createContractCommand);
}
