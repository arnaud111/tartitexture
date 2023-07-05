package esgi.tartitexture.user.application.port.in.usecase;

import esgi.tartitexture.user.domain.model.UserModel;

import java.util.List;

public interface FindUserUseCase {

    UserModel findUser(int id);

    List<UserModel> findAllUsers();
}
