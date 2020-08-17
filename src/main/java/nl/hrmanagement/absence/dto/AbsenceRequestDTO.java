package nl.hrmanagement.absence.dto;

import java.sql.Timestamp;
import java.util.UUID;

public class AbsenceRequestDTO {
    private UUID userId;
    private UUID companyId;
    private String reason;
    private String absenceType;
    private Timestamp startDate;
    private Timestamp endDate;

    public AbsenceRequestDTO(UUID userId, UUID companyId, String reason, String absenceType, Timestamp startDate, Timestamp endDate) {
        this.userId = userId;
        this.companyId = companyId;
        this.reason = reason;
        this.absenceType = absenceType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public AbsenceRequestDTO() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAbsenceType() {
        return absenceType;
    }

    public void setAbsenceType(String absenceType) {
        this.absenceType = absenceType;
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

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }
}
