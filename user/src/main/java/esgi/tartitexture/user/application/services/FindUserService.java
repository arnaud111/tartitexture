package esgi.tartitexture.user.application.services;

import esgi.tartitexture.user.application.port.in.usecase.FindUserUseCase;
import esgi.tartitexture.user.application.port.out.FindUserPort;
import esgi.tartitexture.user.domain.exception.UserNotFoundException;
import esgi.tartitexture.user.domain.model.UserModel;

import java.util.List;

public class FindUserService implements FindUserUseCase {

    private final FindUserPort findUserPort;

    public FindUserService(FindUserPort findUserPort) {
        this.findUserPort = findUserPort;
    }


    @Override
    public UserModel findUser(int id) {
        UserModel userModel = findUserPort.findById(id);

        if (userModel == null) throw UserNotFoundException.notFoundUserId(id);

        return userModel;
    }

    @Override
    public List<UserModel> findAllUsers() {
        return findUserPort.findAll();
    }
}
