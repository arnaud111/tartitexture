package esgi.tartitexture.gateway.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import esgi.tartitexture.gateway.adapter.in.user.request.CreateUserRequest;
import esgi.tartitexture.gateway.adapter.in.user.request.UpdateUserRequest;
import esgi.tartitexture.gateway.adapter.in.user.response.UserResponse;
import esgi.tartitexture.gateway.domain.exception.InternalServerError;
import esgi.tartitexture.gateway.domain.exception.UserNotFoundException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserPersistenceAdapter {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public UserPersistenceAdapter() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public UserResponse findById(int id) {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8097/user/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find user by id");
        }

        if (response.statusCode() == 404) throw UserNotFoundException.notFoundUserId(id);

        try {
            return objectMapper.readValue(response.body(), UserResponse.class);
        } catch (Exception e) {
            System.out.println(e);
            throw new InternalServerError("Error while trying to parse user response");
        }

    }

    public UserResponse[] findAll() {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8097/user/"))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all users");
        }

        try {
            return objectMapper.readValue(response.body(), UserResponse[].class);
        } catch (Exception e) {
            System.out.println(e);
            throw new InternalServerError("Error while trying to parse user response");
        }
    }

    public void create(CreateUserRequest createUserRequest) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8097/user/"))
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(createUserRequest)))
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all user");
        }
    }

    public void update(UpdateUserRequest updateUserRequest, int id) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8097/user/" + id))
                    .PUT(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(updateUserRequest)))
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all user");
        }
    }
}
