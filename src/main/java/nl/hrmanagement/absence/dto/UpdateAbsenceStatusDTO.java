package nl.hrmanagement.absence.dto;

import org.hibernate.sql.Update;

public class UpdateAbsenceStatusDTO {
    private int absenceId;
    private String absenceStatus;

    public UpdateAbsenceStatusDTO(){

    }

    public UpdateAbsenceStatusDTO(int absenceId, String absenceStatus) {
        this.absenceId = absenceId;
        this.absenceStatus = absenceStatus;
    }

    public int getAbsenceId() {
        return absenceId;
    }

    public void setAbsenceId(int absenceId) {
        this.absenceId = absenceId;
    }

    public String getAbsenceStatus() {
        return absenceStatus;
    }

    public void setAbsenceStatus(String absenceStatus) {
        this.absenceStatus = absenceStatus;
    }
}
