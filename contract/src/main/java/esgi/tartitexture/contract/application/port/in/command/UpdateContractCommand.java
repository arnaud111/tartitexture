package esgi.tartitexture.contract.application.port.in.command;

import java.util.Date;

public class UpdateContractCommand {

    private int id;

    private String name;
    private Date endDate;
    private boolean isActivated;
    private boolean isClosed;

    public UpdateContractCommand(int id, String name, Date endDate, boolean isActivated, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.isActivated = isActivated;
        this.isClosed = isClosed;
    }

    public int getId() {
        return id;
    }

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
