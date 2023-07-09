package esgi.tartitexture.gateway;

import esgi.tartitexture.gateway.adapter.out.ContractPersistenceAdapter;
import esgi.tartitexture.gateway.adapter.out.FilePersistenceAdapter;
import esgi.tartitexture.gateway.adapter.out.SigningPersistenceAdapter;
import esgi.tartitexture.gateway.adapter.out.UserPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ContractPersistenceAdapter contractPersistenceAdapter() {
        return new ContractPersistenceAdapter();
    }

    @Bean
    public UserPersistenceAdapter userPersistenceAdapter() {
        return new UserPersistenceAdapter();
    }

    @Bean
    public SigningPersistenceAdapter signingPersistenceAdapter() {
        return new SigningPersistenceAdapter();
    }

    @Bean
    public FilePersistenceAdapter filePersistenceAdapter() {
        return new FilePersistenceAdapter();
    }
}
