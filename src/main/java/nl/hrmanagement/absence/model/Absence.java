package nl.hrmanagement.absence.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Cacheable
@Table(name = "absence")
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "startDate")
    private Timestamp startDate;
    @Column(name = "endDate")
    private Timestamp endDate;
    @Enumerated(EnumType.STRING)
    private AbsenceType type;
    @Enumerated(EnumType.STRING)
    private AbsenceStatus status;
    @Column(name = "reason")
    private String reason;
    @Column(name="userId")
    private UUID userId;
    @Column(name="companyId")
    private UUID companyId;


    public Absence() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Absence(int id, Timestamp startDate, Timestamp endDate, AbsenceType type, AbsenceStatus status, String reason, UUID user, UUID companyId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.status = status;
        this.reason = reason;
        this.userId = user;
        this.companyId = companyId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public AbsenceType getType() {
        return type;
    }

    public void setType(AbsenceType type) {
        this.type = type;
    }

    public AbsenceStatus getStatus() {
        return status;
    }

    public void setStatus(AbsenceStatus status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public UUID getCompanyId() {
        return companyId;
    }
}
