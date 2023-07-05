package esgi.tartitexture.user.application.services;

import esgi.tartitexture.user.application.port.in.command.UpdateUserCommand;
import esgi.tartitexture.user.application.port.in.usecase.UpdateUserUseCase;
import esgi.tartitexture.user.application.port.out.FindUserPort;
import esgi.tartitexture.user.application.port.out.UpdateUserPort;
import esgi.tartitexture.user.domain.exception.UserException;
import esgi.tartitexture.user.domain.model.UserModel;

public class UpdateUserService implements UpdateUserUseCase {

    private final UpdateUserPort updateUserPort;
    private final FindUserPort findUserPort;

    public UpdateUserService(UpdateUserPort updateUserPort, FindUserPort findUserPort) {
        this.updateUserPort = updateUserPort;
        this.findUserPort = findUserPort;
    }

    @Override
    public void update(UpdateUserCommand updateUserCommand) {

        UserModel oldUserModel = findUserPort.findById(updateUserCommand.getId());

        if (oldUserModel == null) throw UserException.notFoundUserId(updateUserCommand.getId());

        UserModel userModel = new UserModel(
                updateUserCommand.getId(),
                updateUserCommand.getEmail(),
                updateUserCommand.getPassword(),
                updateUserCommand.getName(),
                updateUserCommand.getLastname()
        );

        updateUserPort.update(userModel);
    }
}
