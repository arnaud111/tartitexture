package esgi.tartitexture.user.adapter.in.controller;

import esgi.tartitexture.user.adapter.in.controller.request.CreateUserRequest;
import esgi.tartitexture.user.adapter.in.controller.request.UpdateUserRequest;
import esgi.tartitexture.user.adapter.in.controller.response.UserResponse;
import esgi.tartitexture.user.adapter.in.mapper.UserApiMapper;
import esgi.tartitexture.user.application.port.in.command.CreateUserCommand;
import esgi.tartitexture.user.application.port.in.command.UpdateUserCommand;
import esgi.tartitexture.user.application.port.in.usecase.CreateUserUseCase;
import esgi.tartitexture.user.application.port.in.usecase.FindUserUseCase;
import esgi.tartitexture.user.application.port.in.usecase.UpdateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, FindUserUseCase findUserUseCase, UpdateUserUseCase updateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponse> getAll() {
        return UserApiMapper.listUserModelToListUserResponse(findUserUseCase.findAllUsers());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getById(@PathVariable("id") int id) {
        return UserApiMapper.userModelToUserResponse(findUserUseCase.findUser(id));
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {

        CreateUserCommand createUserCommand = new CreateUserCommand(
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                createUserRequest.getName(),
                createUserRequest.getLastname()
        );

        createUserUseCase.createUser(createUserCommand);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable("id") int id, @RequestBody @Valid UpdateUserRequest updateUserRequest) {

        UpdateUserCommand updateUserCommand = new UpdateUserCommand(
                id,
                updateUserRequest.getEmail(),
                updateUserRequest.getPassword(),
                updateUserRequest.getName(),
                updateUserRequest.getLastname()
        );

        updateUserUseCase.update(updateUserCommand);
    }
}
