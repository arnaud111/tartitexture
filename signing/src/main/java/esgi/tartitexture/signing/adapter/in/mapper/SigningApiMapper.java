package esgi.tartitexture.signing.adapter.in.mapper;

import esgi.tartitexture.signing.adapter.in.controller.response.SigningResponse;
import esgi.tartitexture.signing.domain.model.SigningModel;

import java.util.List;
import java.util.stream.Collectors;

public class SigningApiMapper {

    public static SigningResponse signingModelToSigningResponse(SigningModel signingModel) {

        if (signingModel == null) return null;

        return new SigningResponse(
                signingModel.getId(),
                signingModel.getUserId(),
                signingModel.getContractId(),
                signingModel.isSigned()
        );
    }

    public static List<SigningResponse> listSigningModelToListSingingResponse(List<SigningModel> signingModelList) {

        if (signingModelList == null) return null;
        
        return signingModelList.stream().map(SigningApiMapper::signingModelToSigningResponse).collect(Collectors.toList());
    }
}
