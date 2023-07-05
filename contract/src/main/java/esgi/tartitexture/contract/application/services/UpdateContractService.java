package esgi.tartitexture.contract.application.services;

import esgi.tartitexture.contract.application.port.in.command.UpdateContractCommand;
import esgi.tartitexture.contract.application.port.in.usecase.UpdateContractUseCase;
import esgi.tartitexture.contract.application.port.out.FindContractPort;
import esgi.tartitexture.contract.application.port.out.UpdateContractPort;
import esgi.tartitexture.contract.domain.exception.ContractException;
import esgi.tartitexture.contract.domain.model.ContractModel;

public class UpdateContractService implements UpdateContractUseCase {

    private final UpdateContractPort updateContractPort;
    private final FindContractPort findContractPort;

    public UpdateContractService(UpdateContractPort updateContractPort, FindContractPort findContractPort) {
        this.updateContractPort = updateContractPort;
        this.findContractPort = findContractPort;
    }

    @Override
    public void update(UpdateContractCommand updateContractCommand) {

        ContractModel oldContractModel = findContractPort.findById(updateContractCommand.getId());

        if (oldContractModel == null) throw ContractException.notFoundUserId(updateContractCommand.getId());

        ContractModel contractModel = new ContractModel(
                updateContractCommand.getId(),
                updateContractCommand.getName(),
                updateContractCommand.getEndDate(),
                updateContractCommand.isActivated(),
                updateContractCommand.isClosed()
        );

        updateContractPort.update(contractModel);
    }
}
