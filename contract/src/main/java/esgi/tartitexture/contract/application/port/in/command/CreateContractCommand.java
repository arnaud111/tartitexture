package esgi.tartitexture.contract.application.port.in.command;

import java.util.Date;

public class CreateContractCommand {

    private String name;

    private Date endDate;

    public CreateContractCommand(String name, Date endDate) {
        this.name = name;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public Date getEndDate() {
        return endDate;
    }
}
