package esgi.tartitexture.signing.adapter.out.database.repository;

import esgi.tartitexture.signing.adapter.out.database.entity.SigningEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SigningEntityRepository extends CrudRepository<SigningEntity, Integer> {

    @Override
    List<SigningEntity> findAll();
}
