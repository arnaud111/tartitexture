package esgi.tartitexture.contract.adapter.out.mapper;

import esgi.tartitexture.contract.adapter.out.entity.ContractEntity;
import esgi.tartitexture.contract.domain.model.ContractModel;

import java.util.List;
import java.util.stream.Collectors;

public class ContractEntityMapper {

    public static ContractEntity contractModelToContractEntity(ContractModel contractModel) {

        if (contractModel == null) return null;

        return new ContractEntity(
                contractModel.getId(),
                contractModel.getName(),
                contractModel.getEndDate(),
                contractModel.isActivated(),
                contractModel.isClosed()
        );
    }

    public static ContractModel contractEntityToContractModel(ContractEntity contractEntity) {

        if (contractEntity == null) return null;

        return new ContractModel(
                contractEntity.getId(),
                contractEntity.getName(),
                contractEntity.getEndDate(),
                contractEntity.isActivated(),
                contractEntity.isClosed()
        );
    }

    public static List<ContractEntity> listContractModelToListContractEntity(List<ContractModel> contractModelList) {

        if (contractModelList == null) return null;

        return contractModelList.stream().map(ContractEntityMapper::contractModelToContractEntity).collect(Collectors.toList());
    }

    public static List<ContractModel> listContractEntityToListContractModel(List<ContractEntity> contractEntityList) {

        if (contractEntityList == null) return null;

        return contractEntityList.stream().map(ContractEntityMapper::contractEntityToContractModel).collect(Collectors.toList());
    }
}
