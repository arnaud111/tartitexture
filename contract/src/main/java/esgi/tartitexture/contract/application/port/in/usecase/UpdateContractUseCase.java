package esgi.tartitexture.contract.application.port.in.usecase;

import esgi.tartitexture.contract.application.port.in.command.UpdateContractCommand;

public interface UpdateContractUseCase {

    void update(UpdateContractCommand updateContractCommand);

    void activate(int id);

    void deactivate(int id);

    void close(int id);
}
