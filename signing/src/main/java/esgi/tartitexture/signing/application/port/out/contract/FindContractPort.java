package esgi.tartitexture.signing.application.port.out.contract;

import esgi.tartitexture.signing.domain.model.ContractModel;

public interface FindContractPort {

    ContractModel findContractById(int id);

}
