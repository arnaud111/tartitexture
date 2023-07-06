package esgi.tartitexture.signing.adapter.out.database.persistence;

import esgi.tartitexture.signing.adapter.out.database.mapper.SigningEntityMapper;
import esgi.tartitexture.signing.adapter.out.database.repository.SigningEntityRepository;
import esgi.tartitexture.signing.adapter.out.database.entity.SigningEntity;
import esgi.tartitexture.signing.application.port.out.signing.CreateSigningPort;
import esgi.tartitexture.signing.application.port.out.signing.FindSigningPort;
import esgi.tartitexture.signing.application.port.out.signing.UpdateSigningPort;
import esgi.tartitexture.signing.domain.model.SigningModel;

import java.util.List;
import java.util.Optional;

public class SigningPersistenceAdapter implements CreateSigningPort, FindSigningPort, UpdateSigningPort {

    private final SigningEntityRepository signingEntityRepository;

    public SigningPersistenceAdapter(SigningEntityRepository signingEntityRepository) {
        this.signingEntityRepository = signingEntityRepository;
    }


    @Override
    public void save(SigningModel signingModel) {
        SigningEntity signingEntity = SigningEntityMapper.signingModelToSigningEntity(signingModel);

        signingEntityRepository.save(signingEntity);
    }

    @Override
    public SigningModel findById(int id) {
        Optional<SigningEntity> signingEntity = signingEntityRepository.findById(id);
        return signingEntity.map(SigningEntityMapper::signingEntityToSigningModel).orElse(null);
    }

    @Override
    public List<SigningModel> findAll() {
        return SigningEntityMapper.listSigningEntityToListSigningModel(signingEntityRepository.findAll());
    }

    @Override
    public List<SigningModel> findByContractId(int contractId) {
        return SigningEntityMapper.listSigningEntityToListSigningModel(signingEntityRepository.findByContractId(contractId));
    }

    @Override
    public List<SigningModel> findByUserId(int userId) {
        return SigningEntityMapper.listSigningEntityToListSigningModel(signingEntityRepository.findByUserId(userId));
    }

    @Override
    public void update(SigningModel userModel) {
        SigningEntity signingEntity = SigningEntityMapper.signingModelToSigningEntity(userModel);
        signingEntityRepository.save(signingEntity);
    }
}
