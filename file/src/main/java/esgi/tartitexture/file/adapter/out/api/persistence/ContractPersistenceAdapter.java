package esgi.tartitexture.file.adapter.out.api.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import esgi.tartitexture.file.adapter.out.api.mapper.ContractResponseMapper;
import esgi.tartitexture.file.adapter.out.api.response.ContractResponse;
import esgi.tartitexture.file.application.port.out.contract.FindContractPort;
import esgi.tartitexture.file.domain.exception.ContractNotFoundException;
import esgi.tartitexture.file.domain.exception.InternalServerError;
import esgi.tartitexture.file.domain.model.ContractModel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ContractPersistenceAdapter implements FindContractPort {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ContractPersistenceAdapter() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public ContractModel findContractById(int id) {
        HttpResponse<String> response;
        ContractResponse contractResponse;

        try {
            response = httpClient.send(HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:8099/contract/" + id))
                    .build(), HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to get contract from API");
        }

        if (response.statusCode() == 404) throw ContractNotFoundException.notFoundContractId(id);

        try {
            contractResponse = objectMapper.readValue(response.body(), ContractResponse.class);
        } catch (Exception e) {
            throw new InternalServerError("Error while trying to parse contract from API");
        }

        return ContractResponseMapper.contractResponseToContractModel(contractResponse);
    }
}
