package esgi.tartitexture.signing.application.port.in.usecase;

import esgi.tartitexture.signing.domain.model.SigningModel;

import java.util.List;

public interface FindSigningUseCase {

    SigningModel findSigning(int id);

    List<SigningModel> findAllSignings();

    List<SigningModel> findSigningsByContractId(int contractId);

    List<SigningModel> findSigningsByUserId(int userId);
}
