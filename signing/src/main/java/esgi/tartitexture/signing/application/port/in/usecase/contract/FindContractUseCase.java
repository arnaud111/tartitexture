package esgi.tartitexture.signing.application.port.in.usecase.contract;

import esgi.tartitexture.signing.domain.model.ContractModel;

public interface FindContractUseCase {

    ContractModel findContractById(int id);

}
