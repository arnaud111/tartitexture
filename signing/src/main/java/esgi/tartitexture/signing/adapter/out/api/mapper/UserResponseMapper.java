package esgi.tartitexture.signing.adapter.out.api.mapper;

import esgi.tartitexture.signing.adapter.out.api.response.UserResponse;
import esgi.tartitexture.signing.domain.model.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponseMapper {

    public static UserModel userResponseToUserModel(UserResponse userResponse) {

        if (userResponse == null) return null;

        return new UserModel(
                userResponse.getId(),
                userResponse.getEmail(),
                userResponse.getName(),
                userResponse.getLastname()
        );
    }

    public static List<UserModel> listUserResponseToListUserModel(List<UserResponse> userResponseList) {

        if (userResponseList == null) return null;

        return userResponseList.stream().map(UserResponseMapper::userResponseToUserModel).collect(Collectors.toList());
    }
}
