package esgi.tartitexture.contract.adapter.out.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contract")
public class ContractEntity implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    private int id;

    @Column(length = 64, nullable = false)
    private String name;

    @Column
    private Date endDate;

    @Column(length = 64, nullable = false)
    private boolean isActivated;

    @Column(length = 64, nullable = false)
    private boolean isClosed;

    public ContractEntity() {}

    public ContractEntity(int id, String name, Date endDate, boolean isActivated, boolean isClosed) {
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
