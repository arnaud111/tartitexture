package esgi.tartitexture.file;


import esgi.tartitexture.file.adapter.out.api.persistence.ContractPersistenceAdapter;
import esgi.tartitexture.file.adapter.out.storage.persistence.FilePersistenceAdapter;
import esgi.tartitexture.file.application.port.in.usecase.FindFileUseCase;
import esgi.tartitexture.file.application.port.in.usecase.SaveFileUseCase;
import esgi.tartitexture.file.application.services.FindFileService;
import esgi.tartitexture.file.application.services.SaveFileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FilePersistenceAdapter filePersistenceAdapter() {
        return new FilePersistenceAdapter();
    }

    @Bean
    public ContractPersistenceAdapter contractPersistenceAdapter() {
        return new ContractPersistenceAdapter();
    }

    @Bean
    public SaveFileUseCase saveFileUseCase() {
        return new SaveFileService(filePersistenceAdapter(), contractPersistenceAdapter());
    }

    @Bean
    public FindFileUseCase findFileUseCase() {
        return new FindFileService(filePersistenceAdapter());
    }

}
