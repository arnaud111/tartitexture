package esgi.tartitexture.signing.adapter.out.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ContractResponse {

    @JsonProperty(value = "id", required = true)
    public int id;
    @JsonProperty(value = "name", required = true)
    public String name;
    @JsonProperty(value = "endDate")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
