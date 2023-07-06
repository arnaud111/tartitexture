package esgi.tartitexture.signing.application.port.out.user;

import esgi.tartitexture.signing.domain.model.UserModel;

public interface FindUserPort {

    UserModel findUserById(int id);

}
