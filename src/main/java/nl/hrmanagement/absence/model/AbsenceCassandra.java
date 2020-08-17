//package nl.hrmanagement.absence.model;
//
//import com.datastax.driver.core.DataType;
//import org.springframework.data.cassandra.core.mapping.CassandraType;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.Date;
//import java.util.UUID;
//
//@Table(name = "absence")
//public class AbsenceCassandra {
//
//
//    @PrimaryKey
//    private UUID id;
//    private Date startDate;
//    private Date endDate;
//    private AbsenceType type;
//    private AbsenceStatus status;
//    private String reason;
//
//    @Column(name="userId")
//    @CassandraType(type = DataType.Name.UUID)
//    private UUID userId;
//
//    @Column(name="companyId")
//    @CassandraType(type = DataType.Name.UUID)
//    private UUID companyId;
//
//    public AbsenceCassandra(UUID id, Timestamp startDate, Timestamp endDate, AbsenceType type, AbsenceStatus status, String reason, UUID userId, UUID companyId) {
//        this.id = id;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.type = type;
//        this.status = status;
//        this.reason = reason;
//        this.userId = userId;
//        this.companyId = companyId;
//    }
//
//    public AbsenceCassandra() {
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Timestamp startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Timestamp endDate) {
//        this.endDate = endDate;
//    }
//
//    public AbsenceType getType() {
//        return type;
//    }
//
//    public void setType(AbsenceType type) {
//        this.type = type;
//    }
//
//    public AbsenceStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(AbsenceStatus status) {
//        this.status = status;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public UUID getUserId() {
//        return userId;
//    }
//
//    public void setUserId(UUID userId) {
//        this.userId = userId;
//    }
//
//    public UUID getCompanyId() {
//        return companyId;
//    }
//
//    public void setCompanyId(UUID companyId) {
//        this.companyId = companyId;
//    }
//}
