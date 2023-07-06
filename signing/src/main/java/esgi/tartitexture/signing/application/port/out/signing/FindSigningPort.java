package esgi.tartitexture.signing.application.port.out.signing;

import esgi.tartitexture.signing.domain.model.SigningModel;

import java.util.List;

public interface FindSigningPort {

    SigningModel findById(int id);

    List<SigningModel> findAll();
}
