package esgi.tartitexture.user.application.services;

import esgi.tartitexture.user.application.port.in.command.CreateUserCommand;
import esgi.tartitexture.user.application.port.in.usecase.CreateUserUseCase;
import esgi.tartitexture.user.application.port.out.CreateUserPort;
import esgi.tartitexture.user.domain.model.UserModel;

public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPort createUserPort;

    public CreateUserService(CreateUserPort createUserPort) {
        this.createUserPort = createUserPort;
    }

    @Override
    public void createUser(CreateUserCommand createUserCommand) {

        UserModel userModel = new UserModel(
                0,
                createUserCommand.getEmail(),
                createUserCommand.getPassword(),
                createUserCommand.getName(),
                createUserCommand.getLastname()
        );

        createUserPort.save(userModel);
    }
}
