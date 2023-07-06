package esgi.tartitexture.contract.application.services;

import esgi.tartitexture.contract.application.port.in.command.UpdateContractCommand;
import esgi.tartitexture.contract.application.port.in.usecase.UpdateContractUseCase;
import esgi.tartitexture.contract.application.port.out.FindContractPort;
import esgi.tartitexture.contract.application.port.out.UpdateContractPort;
import esgi.tartitexture.contract.domain.exception.ContractClosedException;
import esgi.tartitexture.contract.domain.exception.ContractNotFoundException;
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

        if (oldContractModel == null) throw ContractNotFoundException.notFoundContractId(updateContractCommand.getId());
        if (oldContractModel.isClosed()) throw ContractClosedException.closedId(updateContractCommand.getId());

        ContractModel contractModel = new ContractModel(
                updateContractCommand.getId(),
                updateContractCommand.getName(),
                updateContractCommand.getEndDate(),
                updateContractCommand.isActivated(),
                updateContractCommand.isClosed()
        );

        updateContractPort.update(contractModel);
    }

    @Override
    public void activate(int id) {

        ContractModel oldContractModel = findContractPort.findById(id);

        if (oldContractModel == null) throw ContractNotFoundException.notFoundContractId(id);
        if (oldContractModel.isClosed()) throw ContractClosedException.closedId(id);

        ContractModel contractModel = new ContractModel(
                oldContractModel.getId(),
                oldContractModel.getName(),
                oldContractModel.getEndDate(),
                true,
                oldContractModel.isClosed()
        );

        updateContractPort.update(contractModel);
    }

    @Override
    public void deactivate(int id) {

        ContractModel oldContractModel = findContractPort.findById(id);

        if (oldContractModel == null) throw ContractNotFoundException.notFoundContractId(id);
        if (oldContractModel.isClosed()) throw ContractClosedException.closedId(id);

        ContractModel contractModel = new ContractModel(
                oldContractModel.getId(),
                oldContractModel.getName(),
                oldContractModel.getEndDate(),
                false,
                oldContractModel.isClosed()
        );

        updateContractPort.update(contractModel);

    }

    @Override
    public void close(int id) {

        ContractModel oldContractModel = findContractPort.findById(id);

        if (oldContractModel == null) throw ContractNotFoundException.notFoundContractId(id);

        ContractModel contractModel = new ContractModel(
                oldContractModel.getId(),
                oldContractModel.getName(),
                oldContractModel.getEndDate(),
                oldContractModel.isActivated(),
                true
        );

        updateContractPort.update(contractModel);
    }
}
