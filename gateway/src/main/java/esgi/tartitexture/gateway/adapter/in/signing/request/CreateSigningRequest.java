package esgi.tartitexture.gateway.adapter.in.signing.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;

@Builder
@JsonSerialize
public class CreateSigningRequest {

    @JsonProperty(value = "userId", required = true)
    private int userId;
    @JsonProperty(value = "contractId", required = true)
    private int contractId;

    public CreateSigningRequest(int userId, int contractId) {
        this.userId = userId;
        this.contractId = contractId;
    }

    public int getUserId() {
        return userId;
    }

    public int getContractId() {
        return contractId;
    }
}
