package esgi.tartitexture.gateway.domain.model;

public class SigningModel {

    private final int id;
    private int userId;
    private int contractId;
    private boolean isSigned;

    public SigningModel(int id, int userId, int contractId, boolean isSigned) {
        this.id = id;
        this.userId = userId;
        this.contractId = contractId;
        this.isSigned = isSigned;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }
}
