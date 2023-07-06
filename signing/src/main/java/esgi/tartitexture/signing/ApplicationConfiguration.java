package esgi.tartitexture.signing;


import esgi.tartitexture.signing.adapter.out.api.persistence.ContractPersistenceAdapter;
import esgi.tartitexture.signing.adapter.out.api.persistence.UserPersistenceAdapter;
import esgi.tartitexture.signing.adapter.out.database.persistence.SigningPersistenceAdapter;
import esgi.tartitexture.signing.adapter.out.database.repository.SigningEntityRepository;
import esgi.tartitexture.signing.application.port.in.usecase.signing.CreateSigningUseCase;
import esgi.tartitexture.signing.application.port.in.usecase.signing.FindSigningUseCase;
import esgi.tartitexture.signing.application.port.in.usecase.signing.UpdateSigningUseCase;
import esgi.tartitexture.signing.application.services.CreateSigningService;
import esgi.tartitexture.signing.application.services.FindSigningService;
import esgi.tartitexture.signing.application.services.UpdateSigningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {


    @Autowired
    private SigningEntityRepository signingEntityRepository;

    @Bean
    public SigningPersistenceAdapter signingPersistenceAdapter() {
        return new SigningPersistenceAdapter(signingEntityRepository);
    }

    @Bean
    public ContractPersistenceAdapter contractPersistenceAdapter() {
        return new ContractPersistenceAdapter();
    }

    @Bean
    public UserPersistenceAdapter userPersistenceAdapter() {
        return new UserPersistenceAdapter();
    }

    @Bean
    public CreateSigningUseCase createSigningUseCase() {
        return new CreateSigningService(signingPersistenceAdapter(), contractPersistenceAdapter(), userPersistenceAdapter());
    }

    @Bean
    public FindSigningUseCase findSigningUseCase() {
        return new FindSigningService(signingPersistenceAdapter());
    }

    @Bean
    public UpdateSigningUseCase updateSigningUseCase() {
        return new UpdateSigningService(signingPersistenceAdapter(), signingPersistenceAdapter(), contractPersistenceAdapter(), userPersistenceAdapter());
    }

}
