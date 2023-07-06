package esgi.tartitexture.signing.application.services;

import esgi.tartitexture.signing.application.port.in.usecase.signing.UpdateSigningUseCase;
import esgi.tartitexture.signing.application.port.out.signing.FindSigningPort;
import esgi.tartitexture.signing.application.port.out.signing.UpdateSigningPort;
import esgi.tartitexture.signing.domain.exception.SigningNotFoundException;
import esgi.tartitexture.signing.domain.model.SigningModel;

public class UpdateSigningService implements UpdateSigningUseCase {

    private final UpdateSigningPort updateSigningPort;
    public final FindSigningPort findSigningPort;

    public UpdateSigningService(UpdateSigningPort updateSigningPort, FindSigningPort findSigningPort) {
        this.updateSigningPort = updateSigningPort;
        this.findSigningPort = findSigningPort;
    }

    @Override
    public void sign(int id) {

        SigningModel signingModel = findSigningPort.findById(id);

        if (signingModel == null) throw SigningNotFoundException.notFoundSigningId(id);

        signingModel.setSigned(true);

        updateSigningPort.update(signingModel);
    }
}
