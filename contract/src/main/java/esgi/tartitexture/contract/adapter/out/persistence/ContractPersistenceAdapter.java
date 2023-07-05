package esgi.tartitexture.contract.adapter.out.persistence;

import esgi.tartitexture.contract.adapter.out.entity.ContractEntity;
import esgi.tartitexture.contract.adapter.out.mapper.ContractEntityMapper;
import esgi.tartitexture.contract.adapter.out.repository.ContractEntityRepository;
import esgi.tartitexture.contract.application.port.out.CreateContractPort;
import esgi.tartitexture.contract.application.port.out.FindContractPort;
import esgi.tartitexture.contract.application.port.out.UpdateContractPort;
import esgi.tartitexture.contract.domain.model.ContractModel;

import java.util.List;
import java.util.Optional;

public class ContractPersistenceAdapter implements CreateContractPort, FindContractPort, UpdateContractPort {

    private final ContractEntityRepository contractEntityRepository;

    public ContractPersistenceAdapter(ContractEntityRepository contractEntityRepository) {
        this.contractEntityRepository = contractEntityRepository;
    }


    @Override
    public void save(ContractModel contractModel) {
        ContractEntity contractEntity = ContractEntityMapper.contractModelToContractEntity(contractModel);

        contractEntityRepository.save(contractEntity);
    }

    @Override
    public ContractModel findById(int id) {
        Optional<ContractEntity> contractEntity = contractEntityRepository.findById(id);
        return contractEntity.map(ContractEntityMapper::contractEntityToContractModel).orElse(null);
    }

    @Override
    public List<ContractModel> findAll() {
        return ContractEntityMapper.listContractEntityToListContractModel(contractEntityRepository.findAll());
    }

    @Override
    public void update(ContractModel userModel) {
        ContractEntity contractEntity = ContractEntityMapper.contractModelToContractEntity(userModel);
        contractEntityRepository.save(contractEntity);
    }
}
