package esgi.tartitexture.contract.application.port.in.usecase;

import esgi.tartitexture.contract.domain.model.ContractModel;

import java.util.List;

public interface FindContractUseCase {

    ContractModel findContract(int id);

    List<ContractModel> findAllContracts();
}
