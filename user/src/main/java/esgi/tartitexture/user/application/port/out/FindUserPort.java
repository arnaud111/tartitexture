package esgi.tartitexture.user.application.port.out;

import esgi.tartitexture.user.domain.model.UserModel;

import java.util.List;

public interface FindUserPort {

    UserModel findById(int id);

    List<UserModel> findAll();
}
