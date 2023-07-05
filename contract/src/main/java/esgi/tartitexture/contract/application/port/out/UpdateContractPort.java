package esgi.tartitexture.contract.application.port.out;

import esgi.tartitexture.contract.domain.model.ContractModel;

public interface UpdateContractPort {

    void update(ContractModel contractModel);
}
