package esgi.tartitexture.contract.adapter.in.controller.request;

import java.util.Date;

public class CreateContractRequest {

    private String name;
    private Date endDate;

    public String getName() {
        return name;
    }

    public Date getEndDate() {
        return endDate;
    }
}
