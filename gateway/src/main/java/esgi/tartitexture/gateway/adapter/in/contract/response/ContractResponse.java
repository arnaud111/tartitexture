package esgi.tartitexture.gateway.adapter.in.contract.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ContractResponse {

    @JsonProperty(value = "id", required = true)
    public int id;
    @JsonProperty(value = "name", required = true)
    public String name;
    @JsonProperty(value = "endDate", required = true)
    public Date endDate;
    @JsonProperty(value = "isActivated", required = true)
    public boolean isActivated;
    @JsonProperty(value = "isClosed", required = true)
    public boolean isClosed;

    public ContractResponse() {

    }

    public ContractResponse(int id, String name, Date endDate, boolean isActivated, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.isActivated = isActivated;
        this.isClosed = isClosed;
    }
}
