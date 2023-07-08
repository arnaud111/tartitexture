package esgi.tartitexture.gateway.adapter.in.controller.contract.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;

import java.util.Date;

@Builder
@JsonSerialize
public class UpdateContractRequest {

    @JsonProperty(value = "name", required = true)
    private String name;
    @JsonProperty(value = "endDate", required = true)
    private Date endDate;
    @JsonProperty(value = "isActivated", required = true)
    private boolean isActivated;
    @JsonProperty(value = "isClosed", required = true)
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
