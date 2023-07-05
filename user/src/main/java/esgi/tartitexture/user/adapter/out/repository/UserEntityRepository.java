package esgi.tartitexture.user.adapter.out.repository;

import esgi.tartitexture.user.adapter.out.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {

    @Override
    List<UserEntity> findAll();
}
