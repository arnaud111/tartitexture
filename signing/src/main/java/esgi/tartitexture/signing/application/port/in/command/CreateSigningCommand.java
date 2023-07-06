package esgi.tartitexture.signing.application.port.in.command;

import java.util.Date;

public class CreateSigningCommand {

    private int userId;
    private int contractId;

    public CreateSigningCommand(int userId, int contractId) {
        this.userId = userId;
        this.contractId = contractId;
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
}
