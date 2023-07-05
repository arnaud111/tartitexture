package esgi.tartitexture.contract.adapter.out.repository;

import esgi.tartitexture.contract.adapter.out.entity.ContractEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractEntityRepository extends CrudRepository<ContractEntity, Integer> {

    @Override
    List<ContractEntity> findAll();
}
