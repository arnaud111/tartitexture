package esgi.tartitexture.signing.domain.model;

import java.util.Date;

public class ContractModel {

    private final int id;
    private String name;
    private boolean isActivated;
    private boolean isClosed;
    private Date endDate;

    public ContractModel(int id, String name, Date endDate, boolean isActivated, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.isActivated = isActivated;
        this.isClosed = isClosed;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
