package esgi.tartitexture.signing.application.services;

import esgi.tartitexture.signing.application.port.in.usecase.FindSigningUseCase;
import esgi.tartitexture.signing.application.port.out.signing.FindSigningPort;
import esgi.tartitexture.signing.domain.exception.SigningNotFoundException;
import esgi.tartitexture.signing.domain.model.SigningModel;

import java.util.List;

public class FindSigningService implements FindSigningUseCase {

    private final FindSigningPort findSigningPort;

    public FindSigningService(FindSigningPort findUserPort) {
        this.findSigningPort = findUserPort;
    }


    @Override
    public SigningModel findSigning(int id) {
        SigningModel signingModel = findSigningPort.findById(id);

        if (signingModel == null) throw SigningNotFoundException.notFoundSigningId(id);

        return signingModel;
    }

    @Override
    public List<SigningModel> findAllSignings() {
        return findSigningPort.findAll();
    }

    @Override
    public List<SigningModel> findSigningsByContractId(int contractId) {
        return findSigningPort.findByContractId(contractId);
    }

    @Override
    public List<SigningModel> findSigningsByUserId(int userId) {
        return findSigningPort.findByUserId(userId);
    }
}
