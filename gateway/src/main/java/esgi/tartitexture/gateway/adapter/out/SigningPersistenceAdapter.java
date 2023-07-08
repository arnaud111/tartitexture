package esgi.tartitexture.gateway.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import esgi.tartitexture.gateway.adapter.in.signing.request.CreateSigningRequest;
import esgi.tartitexture.gateway.adapter.in.signing.response.SigningResponse;
import esgi.tartitexture.gateway.domain.exception.ContractClosedException;
import esgi.tartitexture.gateway.domain.exception.InternalServerError;
import esgi.tartitexture.gateway.domain.exception.SigningNotFoundException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SigningPersistenceAdapter {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public SigningPersistenceAdapter() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public SigningResponse findById(int id) {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8100/signing/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find signing by id");
        }

        if (response.statusCode() == 404) throw SigningNotFoundException.notFoundSigningId(id);

        try {
            return objectMapper.readValue(response.body(), SigningResponse.class);
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to parse signing response");
        }
    }

    public SigningResponse[] findAll() {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8100/signing/"))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all signings");
        }

        try {
            return objectMapper.readValue(response.body(), SigningResponse[].class);
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to parse signing response");
        }
    }

    public SigningResponse[] findAllForContract(int id) {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8100/signing/contract/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all signings");
        }

        try {
            return objectMapper.readValue(response.body(), SigningResponse[].class);
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to parse signing response");
        }
    }

    public SigningResponse[] findAllForUser(int id) {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8100/signing/user/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all signings");
        }

        try {
            return objectMapper.readValue(response.body(), SigningResponse[].class);
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to parse signing response");
        }
    }

    public void create(CreateSigningRequest createSigningRequest) {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8100/signing/"))
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(createSigningRequest)))
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all signing");
        }

        if (response.statusCode() == 401) throw ContractClosedException.closedContractId(createSigningRequest.getContractId());
    }

    public void sign(int id) {
        try {
            httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8100/signing/" + id))
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all signing");
        }
    }
}
