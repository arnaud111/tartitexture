package esgi.tartitexture.user.adapter.out.persistence;

import esgi.tartitexture.user.adapter.out.entity.UserEntity;
import esgi.tartitexture.user.adapter.out.mapper.UserEntityMapper;
import esgi.tartitexture.user.adapter.out.repository.UserEntityRepository;
import esgi.tartitexture.user.application.port.out.CreateUserPort;
import esgi.tartitexture.user.application.port.out.FindUserPort;
import esgi.tartitexture.user.application.port.out.UpdateUserPort;
import esgi.tartitexture.user.domain.model.UserModel;

import java.util.List;
import java.util.Optional;

public class UserPersistenceAdapter implements CreateUserPort, FindUserPort, UpdateUserPort {

    private final UserEntityRepository userEntityRepository;

    public UserPersistenceAdapter(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }


    @Override
    public void save(UserModel userModel) {
        UserEntity userEntity = UserEntityMapper.userModelToUserEntity(userModel);

        userEntityRepository.save(userEntity);
    }

    @Override
    public UserModel findById(int id) {
        Optional<UserEntity> userEntity = userEntityRepository.findById(id);
        return userEntity.map(UserEntityMapper::userEntityToUserModel).orElse(null);
    }

    @Override
    public List<UserModel> findAll() {
        return UserEntityMapper.listUserEntityToListUserModel(userEntityRepository.findAll());
    }

    @Override
    public void update(UserModel userModel) {
        UserEntity userEntity = UserEntityMapper.userModelToUserEntity(userModel);
        userEntityRepository.save(userEntity);
    }
}
