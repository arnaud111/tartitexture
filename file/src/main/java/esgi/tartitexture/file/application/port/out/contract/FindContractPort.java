package esgi.tartitexture.file.application.port.out.contract;

import esgi.tartitexture.file.domain.model.ContractModel;

public interface FindContractPort {

    ContractModel findContractById(int id);

}
