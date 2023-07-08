package esgi.tartitexture.gateway.adapter.in.controller.user;

import esgi.tartitexture.gateway.adapter.in.controller.user.request.CreateUserRequest;
import esgi.tartitexture.gateway.adapter.in.controller.user.request.UpdateUserRequest;
import esgi.tartitexture.gateway.adapter.in.controller.user.response.UserResponse;
import esgi.tartitexture.gateway.adapter.out.UserPersistenceAdapter;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserPersistenceAdapter userPersistenceAdapter;

    public UserController(UserPersistenceAdapter userPersistenceAdapter) {
        this.userPersistenceAdapter = userPersistenceAdapter;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse[] getAll() {
        return userPersistenceAdapter.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getById(@PathVariable("id") int id) {
        return userPersistenceAdapter.findById(id);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        userPersistenceAdapter.create(createUserRequest);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable("id") int id, @RequestBody @Valid UpdateUserRequest updateUserRequest) {
        userPersistenceAdapter.update(updateUserRequest, id);
    }
}
