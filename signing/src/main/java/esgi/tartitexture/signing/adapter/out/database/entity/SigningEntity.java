package esgi.tartitexture.signing.adapter.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "signing")
public class SigningEntity implements Serializable {

    @Id
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int contractId;

    @Column(nullable = false)
    private boolean isSigned;

    public SigningEntity() {
    }

    public SigningEntity(int id, int userId, int contractId, boolean isSigned) {
        this.id = id;
        this.userId = userId;
        this.contractId = contractId;
        this.isSigned = isSigned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }
}
