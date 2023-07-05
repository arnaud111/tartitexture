package esgi.tartitexture.user.application.port.out;

import esgi.tartitexture.user.domain.model.UserModel;

public interface UpdateUserPort {

    void update(UserModel userModel);
}
