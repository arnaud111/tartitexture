package esgi.tartitexture.contract.adapter.in.controller.response;

import java.util.Date;

public class ContractResponse {

    public final int id;
    public final String name;
    public final Date endDate;
    public final boolean isActivated;
    public final boolean isClosed;

    public ContractResponse(int id, String name, Date endDate, boolean isActivated, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.isActivated = isActivated;
        this.isClosed = isClosed;
    }
}
