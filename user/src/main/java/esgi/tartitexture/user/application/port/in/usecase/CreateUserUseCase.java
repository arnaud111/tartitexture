package esgi.tartitexture.user.application.port.in.usecase;

import esgi.tartitexture.user.application.port.in.command.CreateUserCommand;
import esgi.tartitexture.user.domain.model.UserModel;

public interface CreateUserUseCase {

    void createUser(CreateUserCommand createUserCommand);
}
