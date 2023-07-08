package esgi.tartitexture.signing.adapter.in.controller.response;

public class SigningResponse {

    public final int id;
    public final int userId;
    public final int contractId;
    public final boolean isSigned;

    public SigningResponse(int id, int userId, int contractId, boolean isSigned) {
        this.id = id;
        this.userId = userId;
        this.contractId = contractId;
        this.isSigned = isSigned;
    }
}
