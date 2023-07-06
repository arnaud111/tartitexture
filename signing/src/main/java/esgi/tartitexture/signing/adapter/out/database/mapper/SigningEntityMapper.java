package esgi.tartitexture.signing.adapter.out.database.mapper;

import esgi.tartitexture.signing.adapter.out.database.entity.SigningEntity;
import esgi.tartitexture.signing.domain.model.SigningModel;

import java.util.List;
import java.util.stream.Collectors;

public class SigningEntityMapper {

    public static SigningEntity signingModelToSigningEntity(SigningModel signingModel) {

        if (signingModel == null) return null;

        return new SigningEntity(
                signingModel.getId(),
                signingModel.getUserId(),
                signingModel.getContractId(),
                signingModel.isSigned()
        );
    }

    public static SigningModel signingEntityToSigningModel(SigningEntity signingEntity) {

        if (signingEntity == null) return null;

        return new SigningModel(
                signingEntity.getId(),
                signingEntity.getUserId(),
                signingEntity.getContractId(),
                signingEntity.isSigned()
        );
    }

    public static List<SigningEntity> listSigningModelToListSigningEntity(List<SigningModel> userModelList) {

        if (userModelList == null) return null;

        return userModelList.stream().map(SigningEntityMapper::signingModelToSigningEntity).collect(Collectors.toList());
    }

    public static List<SigningModel> listSigningEntityToListSigningModel(List<SigningEntity> userEntityList) {

        if (userEntityList == null) return null;

        return userEntityList.stream().map(SigningEntityMapper::signingEntityToSigningModel).collect(Collectors.toList());
    }
}
