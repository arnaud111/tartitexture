package esgi.tartitexture.user.adapter.out.mapper;

import esgi.tartitexture.user.adapter.out.entity.UserEntity;
import esgi.tartitexture.user.domain.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserEntityMapper {

    public static UserEntity userModelToUserEntity(UserModel userModel) {

        if (userModel == null) return null;

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userModel.getId());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setName(userModel.getName());
        userEntity.setLastname(userModel.getLastname());

        return userEntity;
    }

    public static UserModel userEntityToUserModel(UserEntity userEntity) {

        if (userEntity == null) return null;

        return new UserModel(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getName(),
                userEntity.getLastname()
        );
    }

    public static List<UserEntity> listUserModelToListUserEntity(List<UserModel> userModelList) {

        if (userModelList == null) return null;

        return userModelList.stream().map(UserEntityMapper::userModelToUserEntity).collect(Collectors.toList());
    }

    public static List<UserModel> listUserEntityToListUserModel(List<UserEntity> userEntityList) {

        if (userEntityList == null) return null;

        return userEntityList.stream().map(UserEntityMapper::userEntityToUserModel).collect(Collectors.toList());
    }
}
