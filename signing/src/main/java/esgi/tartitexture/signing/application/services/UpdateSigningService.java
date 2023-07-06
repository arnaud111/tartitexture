package esgi.tartitexture.signing.application.services;

import esgi.tartitexture.signing.application.port.in.usecase.signing.UpdateSigningUseCase;
import esgi.tartitexture.signing.application.port.out.contract.FindContractPort;
import esgi.tartitexture.signing.application.port.out.signing.FindSigningPort;
import esgi.tartitexture.signing.application.port.out.signing.UpdateSigningPort;
import esgi.tartitexture.signing.application.port.out.user.FindUserPort;
import esgi.tartitexture.signing.domain.exception.ContractClosedException;
import esgi.tartitexture.signing.domain.exception.SigningNotFoundException;
import esgi.tartitexture.signing.domain.model.ContractModel;
import esgi.tartitexture.signing.domain.model.SigningModel;
import esgi.tartitexture.signing.domain.model.UserModel;

public class UpdateSigningService implements UpdateSigningUseCase {

    private final UpdateSigningPort updateSigningPort;
    private final FindSigningPort findSigningPort;
    private final FindContractPort findContractPort;
    private final FindUserPort findUserPort;

    public UpdateSigningService(UpdateSigningPort updateSigningPort, FindSigningPort findSigningPort, FindContractPort findContractPort, FindUserPort findUserPort) {
        this.updateSigningPort = updateSigningPort;
        this.findSigningPort = findSigningPort;
        this.findContractPort = findContractPort;
        this.findUserPort = findUserPort;
    }

    @Override
    public void sign(int id) {

        SigningModel signingModel = findSigningPort.findById(id);

        if (signingModel == null) throw SigningNotFoundException.notFoundSigningId(id);

        UserModel userModel = findUserPort.findUserById(signingModel.getUserId());
        ContractModel contractModel = findContractPort.findContractById(signingModel.getContractId());

        if (contractModel.isClosed()) throw ContractClosedException.closedContractId(contractModel.getId());

        signingModel.setSigned(true);

        updateSigningPort.update(signingModel);
    }
}
