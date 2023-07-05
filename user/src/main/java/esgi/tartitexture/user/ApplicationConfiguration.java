package esgi.tartitexture.user;

import esgi.tartitexture.user.adapter.out.persistence.UserPersistenceAdapter;
import esgi.tartitexture.user.adapter.out.repository.UserEntityRepository;
import esgi.tartitexture.user.application.port.in.usecase.CreateUserUseCase;
import esgi.tartitexture.user.application.port.in.usecase.FindUserUseCase;
import esgi.tartitexture.user.application.port.in.usecase.UpdateUserUseCase;
import esgi.tartitexture.user.application.services.CreateUserService;
import esgi.tartitexture.user.application.services.FindUserService;
import esgi.tartitexture.user.application.services.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Bean
    public UserPersistenceAdapter userPersistenceAdapter() {
        return new UserPersistenceAdapter(userEntityRepository);
    }

    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserService(userPersistenceAdapter());
    }

    @Bean
    public FindUserUseCase findUserUseCase() {
        return new FindUserService(userPersistenceAdapter());
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase() {
        return new UpdateUserService(userPersistenceAdapter(), userPersistenceAdapter());
    }
}
