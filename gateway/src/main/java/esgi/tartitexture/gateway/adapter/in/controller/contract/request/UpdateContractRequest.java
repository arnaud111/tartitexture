package esgi.tartitexture.gateway.adapter.in.controller.contract.request;

import java.util.Date;

public class UpdateContractRequest {

    private String name;
    private Date endDate;
    private boolean isActivated;
    private boolean isClosed;

    public String getName() {
        return name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
