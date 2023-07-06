package esgi.tartitexture.signing.adapter.in.controller.request;

import java.util.Date;

public class CreateSigningRequest {

    private int userId;
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
