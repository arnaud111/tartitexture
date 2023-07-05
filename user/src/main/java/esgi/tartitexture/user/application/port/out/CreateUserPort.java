package esgi.tartitexture.user.application.port.out;

import esgi.tartitexture.user.domain.model.UserModel;

public interface CreateUserPort {

    void save(UserModel userModel);
}
