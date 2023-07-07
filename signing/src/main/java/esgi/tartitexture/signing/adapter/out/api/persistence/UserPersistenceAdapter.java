package esgi.tartitexture.signing.adapter.out.api.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import esgi.tartitexture.signing.adapter.out.api.mapper.UserResponseMapper;
import esgi.tartitexture.signing.adapter.out.api.response.UserResponse;
import esgi.tartitexture.signing.application.port.out.user.FindUserPort;
import esgi.tartitexture.signing.domain.exception.InternalServerError;
import esgi.tartitexture.signing.domain.exception.UserNotFoundException;
import esgi.tartitexture.signing.domain.model.UserModel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserPersistenceAdapter implements FindUserPort {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public UserPersistenceAdapter() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public UserModel findUserById(int id) {
        HttpResponse<String> response;
        UserResponse userResponse;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8097/user/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to get user from API");
        }

        if (response.statusCode() == 404) throw UserNotFoundException.notFoundUserId(id);

        try {
            userResponse = objectMapper.readValue(response.body(), UserResponse.class);
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to parse user from API");
        }

        return UserResponseMapper.userResponseToUserModel(userResponse);
    }

}
