package esgi.tartitexture.gateway.adapter.in.signing.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SigningResponse {

    @JsonProperty(value = "id", required = true)
    public int id;
    @JsonProperty(value = "userId", required = true)
    private int userId;
    @JsonProperty(value = "contractId", required = true)
    private int contractId;
    @JsonProperty(value = "isSigned", required = true)
    private boolean isSigned;

    public SigningResponse() {

    }

    public SigningResponse(int id, int userId, int contractId, boolean isSigned) {
        this.id = id;
        this.userId = userId;
        this.contractId = contractId;
        this.isSigned = isSigned;
    }
}
