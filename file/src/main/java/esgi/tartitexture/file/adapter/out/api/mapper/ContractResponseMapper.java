package esgi.tartitexture.file.adapter.out.api.mapper;

import esgi.tartitexture.file.adapter.out.api.response.ContractResponse;
import esgi.tartitexture.file.domain.model.ContractModel;

import java.util.List;
import java.util.stream.Collectors;

public class ContractResponseMapper {

    public static ContractModel contractResponseToContractModel(ContractResponse contractResponse) {

        if (contractResponse == null) return null;

        return new ContractModel(
                contractResponse.getId(),
                contractResponse.getName(),
                contractResponse.getEndDate(),
                contractResponse.isActivated(),
                contractResponse.isClosed()
        );
    }

    public static List<ContractModel> listContractResponseToListContractModel(List<ContractResponse> contractResponseList) {

        if (contractResponseList == null) return null;

        return contractResponseList.stream().map(ContractResponseMapper::contractResponseToContractModel).collect(Collectors.toList());
    }
}
