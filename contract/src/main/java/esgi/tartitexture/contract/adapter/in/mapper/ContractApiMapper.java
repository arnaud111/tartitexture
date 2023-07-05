package esgi.tartitexture.contract.adapter.in.mapper;

import esgi.tartitexture.contract.adapter.in.controller.response.ContractResponse;
import esgi.tartitexture.contract.domain.model.ContractModel;

import java.util.List;
import java.util.stream.Collectors;

public class ContractApiMapper {

    public static ContractResponse contractModelToContractResponse(ContractModel contractModel) {

        if (contractModel == null) return null;

        return new ContractResponse(
                contractModel.getId(),
                contractModel.getName(),
                contractModel.getEndDate(),
                contractModel.isActivated(),
                contractModel.isClosed()
        );
    }

    public static List<ContractResponse> listContractModelToListContractResponse(List<ContractModel> contractModelList) {

        if (contractModelList == null) return null;
        
        return contractModelList.stream().map(ContractApiMapper::contractModelToContractResponse).collect(Collectors.toList());
    }
}
