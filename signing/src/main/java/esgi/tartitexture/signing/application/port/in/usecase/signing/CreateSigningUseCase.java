package esgi.tartitexture.signing.application.port.in.usecase.signing;

import esgi.tartitexture.signing.application.port.in.command.CreateSigningCommand;

public interface CreateSigningUseCase {

    void createSigning(CreateSigningCommand createSigningCommand);
}
