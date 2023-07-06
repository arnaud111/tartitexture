package esgi.tartitexture.contract;


import esgi.tartitexture.contract.adapter.out.persistence.ContractPersistenceAdapter;
import esgi.tartitexture.contract.adapter.out.repository.ContractEntityRepository;
import esgi.tartitexture.contract.application.port.in.usecase.CreateContractUseCase;
import esgi.tartitexture.contract.application.port.in.usecase.FindContractUseCase;
import esgi.tartitexture.contract.application.port.in.usecase.UpdateContractUseCase;
import esgi.tartitexture.contract.application.services.CreateContractService;
import esgi.tartitexture.contract.application.services.FindContractService;
import esgi.tartitexture.contract.application.services.UpdateContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {


    @Autowired
    private ContractEntityRepository contractEntityRepository;

    @Bean
    public ContractPersistenceAdapter contractPersistenceAdapter() {
        return new ContractPersistenceAdapter(contractEntityRepository);
    }

    @Bean
    public CreateContractUseCase createContractUseCase() {
        return new CreateContractService(contractPersistenceAdapter());
    }

    @Bean
    public FindContractUseCase findContractUseCase() {
        return new FindContractService(contractPersistenceAdapter());
    }

    @Bean
    public UpdateContractUseCase updateContractUseCase() {
        return new UpdateContractService(contractPersistenceAdapter(), contractPersistenceAdapter());
    }
}
