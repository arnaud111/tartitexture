package esgi.tartitexture.user.adapter.in.mapper;

import esgi.tartitexture.user.adapter.in.controller.response.UserResponse;
import esgi.tartitexture.user.domain.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserApiMapper {

    public static UserResponse userModelToUserResponse(UserModel userModel) {

        if (userModel == null) return null;

        return new UserResponse(
                userModel.getId(),
                userModel.getEmail(),
                userModel.getName(),
                userModel.getLastname()
        );
    }

    public static List<UserResponse> listUserModelToListUserResponse(List<UserModel> userModelList) {

        if (userModelList == null) return null;
        
        return userModelList.stream().map(UserApiMapper::userModelToUserResponse).collect(Collectors.toList());
    }
}
