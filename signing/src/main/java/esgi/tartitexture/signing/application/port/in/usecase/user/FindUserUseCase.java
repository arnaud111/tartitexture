package esgi.tartitexture.signing.application.port.in.usecase.user;

import esgi.tartitexture.signing.domain.model.UserModel;

public interface FindUserUseCase {

    UserModel findUserById(int id);

}
