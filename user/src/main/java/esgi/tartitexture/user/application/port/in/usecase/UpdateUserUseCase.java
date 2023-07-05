package esgi.tartitexture.user.application.port.in.usecase;

import esgi.tartitexture.user.application.port.in.command.UpdateUserCommand;

public interface UpdateUserUseCase {

    void update(UpdateUserCommand updateUserCommand);
}
