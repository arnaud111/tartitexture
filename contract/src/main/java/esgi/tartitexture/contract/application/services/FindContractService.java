package esgi.tartitexture.contract.application.services;

import esgi.tartitexture.contract.application.port.in.usecase.FindContractUseCase;
import esgi.tartitexture.contract.application.port.out.FindContractPort;
import esgi.tartitexture.contract.domain.exception.ContractNotFoundException;
import esgi.tartitexture.contract.domain.model.ContractModel;

import java.util.List;

public class FindContractService implements FindContractUseCase {

    private final FindContractPort findContractPort;

    public FindContractService(FindContractPort findContractPort) {
        this.findContractPort = findContractPort;
    }


    @Override
    public ContractModel findContract(int id) {
        ContractModel contractModel = findContractPort.findById(id);

        if (contractModel == null) throw ContractNotFoundException.notFoundContractId(id);

        return contractModel;
    }

    @Override
    public List<ContractModel> findAllContracts() {
        return findContractPort.findAll();
    }
}
