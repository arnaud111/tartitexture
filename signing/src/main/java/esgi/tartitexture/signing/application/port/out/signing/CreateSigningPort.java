package esgi.tartitexture.signing.application.port.out.signing;

import esgi.tartitexture.signing.domain.model.SigningModel;

public interface CreateSigningPort {

    void save(SigningModel signingModel);
}
