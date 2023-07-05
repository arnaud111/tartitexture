package esgi.tartitexture.contract.application.port.out;

import esgi.tartitexture.contract.domain.model.ContractModel;

import java.util.List;

public interface FindContractPort {

    ContractModel findById(int id);

    List<ContractModel> findAll();
}
