package esgi.tartitexture.gateway.adapter.out;

import com.fasterxml.jackson.databind.ObjectMapper;
import esgi.tartitexture.gateway.adapter.in.contract.request.CreateContractRequest;
import esgi.tartitexture.gateway.adapter.in.contract.request.UpdateContractRequest;
import esgi.tartitexture.gateway.adapter.in.contract.response.ContractResponse;
import esgi.tartitexture.gateway.domain.exception.ContractNotFoundException;
import esgi.tartitexture.gateway.domain.exception.InternalServerError;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ContractPersistenceAdapter {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ContractPersistenceAdapter() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public ContractResponse findContractById(int id) {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find contract by id");
        }

        if (response.statusCode() == 404) throw ContractNotFoundException.notFoundContractId(id);

        try {
            return objectMapper.readValue(response.body(), ContractResponse.class);
        } catch (Exception e) {
            System.out.println(e);
            throw new InternalServerError("Error while trying to parse contract response");
        }

    }

    public ContractResponse[] findAllContract() {
        HttpResponse<String> response;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/"))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all contracts");
        }

        try {
            return objectMapper.readValue(response.body(), ContractResponse[].class);
        } catch (Exception e) {
            System.out.println(e);
            throw new InternalServerError("Error while trying to parse contract response");
        }
    }

    public void create(CreateContractRequest createContractRequest) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/"))
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(createContractRequest)))
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all contracts");
        }
    }

    public void update(UpdateContractRequest updateContractRequest, int id) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/" + id))
                    .PUT(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(updateContractRequest)))
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all contracts");
        }
    }

    public void activateContract(int id) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/" + id + "/activate"))
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all contracts");
        }
    }

    public void deactivateContract(int id) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/" + id + "/deactivate"))
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all contracts");
        }
    }

    public void closeContract(int id) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/" + id + "/close"))
                    .method("PATCH", HttpRequest.BodyPublishers.noBody())
                    .header("Content-Type", "application/json")
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to find all contracts");
        }
    }
}
